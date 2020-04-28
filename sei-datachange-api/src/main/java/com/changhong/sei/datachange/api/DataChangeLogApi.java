package com.changhong.sei.datachange.api;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.datachange.dto.DataChangeLogDto;
import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.datachange.dto.DataChangeLogQuickQueryParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (DataChangeLog)数据变更日志API接口
 *
 * @author sei
 * @since 2020-04-24 10:03:02
 */
@Valid
@FeignClient(name = "sei-datachange", path = "dataChangeLog")
public interface DataChangeLogApi extends BaseEntityApi<DataChangeLogDto> {

    /**
     * 分页查询数据变更历史
     * @param queryParam 查询参数
     * @return 查询结果
     */
    @PostMapping(path = "queryByPage", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询数据变更历史", notes = "通过关键属性和时间段分页查询数据变更历史")
    ResultData<PageResult<DataChangeLogDto>> queryByPage(@RequestBody @Valid DataChangeLogQuickQueryParam queryParam);
}