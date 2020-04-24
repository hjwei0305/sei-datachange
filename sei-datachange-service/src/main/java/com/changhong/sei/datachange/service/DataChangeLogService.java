package com.changhong.sei.datachange.service;

import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.datachange.dao.DataChangeLogDao;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * (DataChangeLog)业务逻辑实现类
 *
 * @author sei
 * @since 2020-04-24 10:02:46
 */
@Service("dataChangeLogService")
public class DataChangeLogService extends BaseEntityService<DataChangeLog> {
    @Autowired
    private DataChangeLogDao dao;

    @Override
    protected BaseEntityDao<DataChangeLog> getDao() {
        return dao;
    }

}