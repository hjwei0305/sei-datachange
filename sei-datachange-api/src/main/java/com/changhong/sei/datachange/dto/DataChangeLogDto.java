package com.changhong.sei.datachange.dto;

import java.util.Date;
import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.core.dto.datachange.OperationCategory;
import com.changhong.sei.core.dto.serializer.EnumJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

/**
 * (DataChangeLog)DTO类
 *
 * @author sei
 * @since 2020-04-24 10:03:02
 */
@ApiModel(description = "数据变更日志DTO")
public class DataChangeLogDto extends BaseEntityDto {
private static final long serialVersionUID = -84754099001354808L;
    /**
     * 业务实体类名
     */
    @NotBlank
    @Size(max = 100)
    @ApiModelProperty(value = "业务实体类名", required = true)
    private String className;
    /**
     * 业务实体名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "业务实体名称", required = true)
    private String entityName;
    /**
     * 操作类型
     */
    @NotNull
    @ApiModelProperty(value = "操作类型", required = true)
    @JsonSerialize(using = EnumJsonSerializer.class)
    private OperationCategory operationCategory;
    /**
     * 业务实体Id
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "业务实体Id", required = true)
    private String entityId;
    /**
     * 租户代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "租户代码", required = true)
    private String tenantCode;
    /**
     * 操作人Id
     */
    @NotBlank
    @Size(max = 36)
    @ApiModelProperty(value = "操作人Id", required = true)
    private String operatorId;
    /**
     * 操作人账号
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "操作人账号", required = true)
    private String operatorAccount;
    /**
     * 操作人名称
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "操作人名称", required = true)
    private String operatorName;
    /**
     * 操作时间
     */
    @NotNull
    @ApiModelProperty(value = "操作时间", required = true)
    private Date operateTime;
    /**
     * 属性名
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "属性名", required = true)
    private String propertyName;
    /**
     * 属性描述
     */
    @NotBlank
    @Size(max = 50)
    @ApiModelProperty(value = "属性描述", required = true)
    private String propertyRemark;
    /**
     * 原值
     */
    @ApiModelProperty(value = "原值")
    private String originalValue;
    /**
     * 新值
     */
    @ApiModelProperty(value = "新值")
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