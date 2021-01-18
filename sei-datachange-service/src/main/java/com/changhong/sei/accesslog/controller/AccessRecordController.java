package com.changhong.sei.accesslog.controller;

import com.changhong.sei.accesslog.api.AccessRecordApi;
import com.changhong.sei.accesslog.dto.AccessRecordCreateRequest;
import com.changhong.sei.accesslog.dto.AccessRecordFeatureResponse;
import com.changhong.sei.accesslog.dto.AccessRecordUserResponse;
import com.changhong.sei.accesslog.dto.TimePeriod;
import com.changhong.sei.accesslog.entity.AccessRecord;
import com.changhong.sei.accesslog.service.AccessRecordService;
import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.context.SessionUser;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.util.HttpUtils;
import com.changhong.sei.util.EnumUtils;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 访问记录(AccessRecord)表控制层
 *
 * @author sei
 * @since 2020-03-30 11:09:01
 */
@RestController
@Api(value = "AccessRecordApi", tags = "访问记录服务")
public class AccessRecordController implements AccessRecordApi {
    /**
     * 访问记录服务对象
     */
    @Autowired
    private AccessRecordService accessRecordService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * 添加访问记录
     *
     * @param request 参数
     * @return 添加结果
     */
    @Override
    public ResultData<Void> addRecord(AccessRecordCreateRequest record, HttpServletRequest request) {
        SessionUser sessionUser = ContextUtil.getSessionUser();
        AccessRecord accessRecord = new AccessRecord();
        accessRecord.setType("PAGE");

        accessRecord.setTenantCode(sessionUser.getTenantCode());
        accessRecord.setUserId(sessionUser.getUserId());
        accessRecord.setUserAccount(sessionUser.getLoginAccount());
        accessRecord.setUserName(sessionUser.getUserName());
        accessRecord.setAppModule(record.getAppCode());
        accessRecord.setFeature(record.getFeature());
        accessRecord.setTraceId("NaN");
        accessRecord.setPath(record.getUrl());
        accessRecord.setUrl(record.getUrl());
        accessRecord.setMethod("GET");
        accessRecord.setDuration(-1L);
        accessRecord.setIp(HttpUtils.getClientIP(request));
        //解析agent字符串
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));

        accessRecord.setBrowser(userAgent.getBrowser().getName());
        accessRecord.setOsName(userAgent.getOperatingSystem().getName());
        accessRecord.setAccessTime(LocalDateTime.now());

        return accessRecordService.addRecord(accessRecord);
    }

    /**
     * 获取时间段周期
     */
    @Override
    public ResultData<Map<String, String>> getPeriods() {
        return ResultData.success(EnumUtils.getEnumMap(TimePeriod.class));
    }

    /**
     * 指定时间段访问top N的功能
     */
    @Override
    public ResultData<List<AccessRecordFeatureResponse>> getTopFeatures(String tenant, String type, String period, int topNum) {
        TimePeriod timePeriod = EnumUtils.getEnum(TimePeriod.class, period);
        return accessRecordService.getTopFeatures(tenant, type, timePeriod, topNum);
    }

    /**
     * 指定时间段访问top N的人
     */
    @Override
    public ResultData<List<AccessRecordUserResponse>> getTopUsers(String tenant, String type, String period, int topNum) {
        TimePeriod timePeriod = EnumUtils.getEnum(TimePeriod.class, period);
        return accessRecordService.getTopUsers(tenant, type, timePeriod, topNum);
    }

    /**
     * 指定时间段某一功能访问的人
     */
    @Override
    public ResultData<List<AccessRecordUserResponse>> getUsersByFeature(String tenant, String feature, String period, int topNum) {
        TimePeriod timePeriod = EnumUtils.getEnum(TimePeriod.class, period);
        return accessRecordService.getUsersByFeature(tenant, feature, timePeriod, topNum);
    }

    /**
     * 指定时间段某人访问的功能
     */
    @Override
    public ResultData<List<AccessRecordFeatureResponse>> getFeaturesByUser(String tenant, String account, String period, int topNum) {
        TimePeriod timePeriod = EnumUtils.getEnum(TimePeriod.class, period);
        return accessRecordService.getFeaturesByUser(tenant, account, timePeriod, topNum);
    }
}