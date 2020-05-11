package com.changhong.sei.datachange.service;

import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.datachange.DataHistoryItem;
import com.changhong.sei.core.dto.datachange.DataHistoryRecord;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.datachange.dto.DataChangeLogDto;
import com.changhong.sei.datachange.dto.DataChangeLogQuickQueryParam;
import com.changhong.sei.datachange.dto.LogEntityName;
import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.datachange.dao.DataChangeLogDao;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.*;


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

    /**
     * 保存实体数据变更记录
     * @param record 数据变更记录
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveDataHistoryRecord(DataHistoryRecord record) {
        if (Objects.isNull(record) || CollectionUtils.isEmpty(record.getItems())) {
            return;
        }
        List<DataHistoryItem> items = record.getItems();
        items.forEach(item -> {
            DataChangeLog log = new DataChangeLog();
            // 设置抬头数据
            log.setClassName(record.getClassName());
            log.setEntityName(record.getEntityName());
            log.setOperationCategory(record.getOperationCategory());
            log.setEntityId(record.getEntityId());
            log.setTenantCode(record.getTenantCode());
            log.setOperatorId(record.getOperatorId());
            log.setOperatorAccount(record.getOperatorAccount());
            log.setOperatorName(record.getOperatorName());
            log.setOperateTime(record.getOperateTime());
            // 设置行项目数据
            log.setPropertyName(item.getPropertyName());
            log.setPropertyRemark(item.getPropertyRemark());
            log.setOriginalValue(item.getOriginalValue());
            log.setNewValue(item.getNewValue());
            dao.save(log);
        });
    }

    /**
     * 分页查询数据变更历史
     *
     * @param queryParam 查询参数
     * @param tenantCode 租户代码
     * @return 查询结果
     */
    public PageResult<DataChangeLog> queryByPage(DataChangeLogQuickQueryParam queryParam, String tenantCode) {
        return dao.queryByPage(queryParam, tenantCode);
    }

    /**
     * 获取一个业务实体的数据变更历史
     *
     * @param entityId 业务实体Id
     * @return 数据变更历史
     */
    public List<DataChangeLog> findLogsByEntityId(String entityId, String tenantCode) {
        return dao.findByEntityIdAndTenantCodeOrderByOperateTimeDesc(entityId, tenantCode);
    }

    /**
     * 获取业务实体的清单
     * @return 业务实体的清单
     */
    public List<LogEntityName> getEntityNames() {
        List<Object[]> entityNames = dao.getEntityNames();
        if (CollectionUtils.isEmpty(entityNames)) {
            return new LinkedList<>();
        }
        List<LogEntityName> logEntityNames = new LinkedList<>();
        entityNames.forEach(names-> {
            LogEntityName logEntityName = new LogEntityName();
            logEntityName.setClassName(names[0].toString());
            logEntityName.setEntityName(names[1].toString());
            logEntityNames.add(logEntityName);
        });
        return logEntityNames;
    }
}