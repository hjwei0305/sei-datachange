package com.changhong.sei.datachange.dao;

import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.core.dao.BaseEntityDao;
import org.springframework.stereotype.Repository;

/**
 * (DataChangeLog)数据库访问类
 *
 * @author sei
 * @since 2020-04-24 10:02:46
 */
@Repository
public interface DataChangeLogDao extends BaseEntityDao<DataChangeLog>, DataChangeLogExtDao {
}