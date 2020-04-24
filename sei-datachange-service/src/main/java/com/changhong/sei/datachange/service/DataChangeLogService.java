package com.changhong.sei.datachange.service;

import com.changhong.sei.core.dto.datachange.DataHistoryItem;
import com.changhong.sei.core.dto.datachange.DataHistoryRecord;
import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.datachange.dao.DataChangeLogDao;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


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
}