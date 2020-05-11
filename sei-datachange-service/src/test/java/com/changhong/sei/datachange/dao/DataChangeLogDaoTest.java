package com.changhong.sei.datachange.dao;

import com.changhong.sei.core.test.BaseUnitTest;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.datachange.entity.DataChangeLog;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 实现功能:
 *
 * @author 王锦光 wangjg
 * @version 2020-04-30 17:19
 */
public class DataChangeLogDaoTest extends BaseUnitTest {
    @Autowired
    private DataChangeLogDao dao;

    @Test
    public void findByProperty() {
        String id = "87EADDE3-88F6-11EA-9ABD-0242C0A84615";
        DataChangeLog log = dao.findByProperty("id", id);
        Assert.assertNotNull(log);
        LOG.debug(JsonUtils.toJson(log));
    }
}