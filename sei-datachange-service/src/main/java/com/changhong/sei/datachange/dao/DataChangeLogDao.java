package com.changhong.sei.datachange.dao;

import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.core.dao.BaseEntityDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DataChangeLog)数据库访问类
 *
 * @author sei
 * @since 2020-04-24 10:02:46
 */
@Repository
public interface DataChangeLogDao extends BaseEntityDao<DataChangeLog>, DataChangeLogExtDao {
    /**
     * 获取业务实体的清单
     * @return 业务实体的清单
     */
    @Query("select log.className, log.entityName from DataChangeLog log group by log.className, log.entityName")
    List<Object[]> getEntityNames();

    /**
     * 获取一个业务实体的数据变更历史
     * @param entityId 业务实体Id
     * @param tenantCode 租户代码
     * @return 数据变更历史
     */
    List<DataChangeLog> findByEntityIdAndTenantCodeOrderByOperateTimeDesc(String entityId, String tenantCode);
}