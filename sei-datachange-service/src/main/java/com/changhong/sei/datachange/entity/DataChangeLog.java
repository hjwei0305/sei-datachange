package com.changhong.sei.datachange.entity;

import java.util.Date;

import com.changhong.sei.core.dto.datachange.OperationCategory;
import com.changhong.sei.core.dto.serializer.EnumJsonSerializer;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (DataChangeLog)实体类
 *
 * @author sei
 * @since 2020-04-24 10:02:46
 */
@Entity
@Table(name = "data_change_log")
@DynamicInsert
@DynamicUpdate
public class DataChangeLog extends BaseEntity {
private static final long serialVersionUID = -40093020360838573L;
    /**
     * 业务实体类名
     */
    @Column(name = "class_name")
    private String className;
    /**
     * 业务实体名称
     */
    @Column(name = "entity_name")
    private String entityName;
    /**
     * 操作类型
     */
    @Enumerated(EnumType.STRING)
    @JsonSerialize(using = EnumJsonSerializer.class)
    @Column(name = "operation_category")
    private OperationCategory operationCategory;
    /**
     * 业务实体Id
     */
    @Column(name = "entity_id")
    private String entityId;
    /**
     * 租户代码
     */
    @Column(name = "tenant_code")
    private String tenantCode;
    /**
     * 操作人Id
     */
    @Column(name = "operator_id")
    private String operatorId;
    /**
     * 操作人账号
     */
    @Column(name = "operator_account")
    private String operatorAccount;
    /**
     * 操作人名称
     */
    @Column(name = "operator_name")
    private String operatorName;
    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    private Date operateTime;
    /**
     * 属性名
     */
    @Column(name = "property_name")
    private String propertyName;
    /**
     * 属性描述
     */
    @Column(name = "property_remark")
    private String propertyRemark;
    /**
     * 原值
     */
    @Column(name = "original_value")
    private String originalValue;
    /**
     * 新值
     */
    @Column(name = "new_value")
    private String newValue;

        
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
        
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
        
    public OperationCategory getOperationCategory() {
        return operationCategory;
    }

    public void setOperationCategory(OperationCategory operationCategory) {
        this.operationCategory = operationCategory;
    }
        
    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
        
    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
        
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
        
    public String getOperatorAccount() {
        return operatorAccount;
    }

    public void setOperatorAccount(String operatorAccount) {
        this.operatorAccount = operatorAccount;
    }
        
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
        
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
        
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
        
    public String getPropertyRemark() {
        return propertyRemark;
    }

    public void setPropertyRemark(String propertyRemark) {
        this.propertyRemark = propertyRemark;
    }
        
    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }
        
    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

}