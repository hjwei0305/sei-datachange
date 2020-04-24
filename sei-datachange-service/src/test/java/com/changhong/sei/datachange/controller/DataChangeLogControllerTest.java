package com.changhong.sei.datachange.controller;

import com.changhong.sei.datachange.dto.DataChangeLogDto;
import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

}