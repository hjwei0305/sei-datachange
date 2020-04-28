package com.changhong.sei.datachange.dao;

import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.datachange.dto.DataChangeLogQuickQueryParam;
import com.changhong.sei.datachange.entity.DataChangeLog;

/**
 * 实现功能: 数据变更历史数据访问扩展接口
 *
 * @author 王锦光 wangjg
 * @version 2020-04-28 15:05
 */
public interface DataChangeLogExtDao {
    /**
     * 分页查询数据变更历史
     *
     * @param queryParam 查询参数
     * @param tenantCode 租户代码
     * @return 查询结果
     */
    PageResult<DataChangeLog> queryByPage(DataChangeLogQuickQueryParam queryParam, String tenantCode);
}
