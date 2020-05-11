package com.changhong.sei.datachange.controller;

import com.changhong.sei.core.dto.serach.PageInfo;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.datachange.dto.DataChangeLogDto;
import com.changhong.sei.datachange.dto.DataChangeLogQuickQueryParam;
import com.changhong.sei.datachange.dto.LogEntityName;
import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.util.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * (DataChangeLog)单元测试类
 *
 * @author sei
 * @since 2020-04-24 10:07:06
 */
public class DataChangeLogControllerTest extends BaseUnitTest {

    @Autowired
    private DataChangeLogController controller;

    @Test
    public void findOne() {
        String id = "123";
        ResultData<DataChangeLogDto> resultData = controller.findOne(id);
        LOG.debug(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }

    @Test
    public void queryByPage() {
        DataChangeLogQuickQueryParam queryParam = new DataChangeLogQuickQueryParam();
        queryParam.setClassName("com.changhong.sei.basic.entity.Corporation");
        //queryParam.setQuickSearchValue("成功");
        queryParam.setStartTime(DateUtils.parseTime("2020-04-20 09:26:00"));
        queryParam.setEndTime(DateUtils.getCurrentDateTime());
        queryParam.setPageInfo(new PageInfo());
        ResultData<PageResult<DataChangeLogDto>> resultData = controller.queryByPage(queryParam);
        System.out.println(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }

    @Test
    public void getEntityNames() {
        ResultData<List<LogEntityName>> resultData = controller.getEntityNames();
        System.out.println(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }

    @Test
    public void findLogsByEntityId() {
        String entityId = "63440EA8-91A4-11EA-8585-0242C0A84603";
        ResultData<List<DataChangeLogDto>> resultData = controller.findLogsByEntityId(entityId);
        LOG.debug(JsonUtils.toJson(resultData));
        Assert.assertTrue(resultData.successful());
    }
}