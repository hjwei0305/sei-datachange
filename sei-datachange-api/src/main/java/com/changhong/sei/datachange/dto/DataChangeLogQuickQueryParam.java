package com.changhong.sei.datachange.dto;

import com.changhong.sei.core.dto.serach.QuickQueryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 实现功能: 数据变更历史分页查询参数
 *
 * @author 王锦光 wangjg
 * @version 2020-04-28 14:29
 */
@ApiModel("数据变更历史分页查询参数")
public class DataChangeLogQuickQueryParam extends QuickQueryParam {
    private static final long serialVersionUID = 3623732498549429322L;
    /**
     * 业务实体名称
     */
    @ApiModelProperty("业务实体名称")
    private String entityName;

    /**
     * 操作人名称
     */
    @ApiModelProperty("操作人名称")
    private String operatorName;

    /**
     * 开始时间
     */
    @NotNull
    @ApiModelProperty(value = "开始时间", required = true)
    private Date startTime;

    /**
     * 截止时间
     */
    @NotNull
    @ApiModelProperty(value = "截止时间", required = true)
    private Date endTime;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
