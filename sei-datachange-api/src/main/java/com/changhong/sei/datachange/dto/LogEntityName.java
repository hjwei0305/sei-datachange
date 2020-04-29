package com.changhong.sei.datachange.dto;

import java.io.Serializable;

/**
 * 实现功能: 变更日志的业务实体名
 *
 * @author 王锦光 wangjg
 * @version 2020-04-29 9:24
 */
public class LogEntityName implements Serializable {
    private static final long serialVersionUID = -1961326954533443241L;
    /**
     * 业务实体类名
     */
    private String className;

    /**
     * 业务实体名称
     */
    private String entityName;

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
}
