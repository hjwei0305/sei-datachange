package com.changhong.sei.datachange.dao.impl;

import com.changhong.sei.core.dao.impl.BaseEntityDaoImpl;
import com.changhong.sei.core.dao.impl.PageResultUtil;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.entity.search.QuerySql;
import com.changhong.sei.datachange.dao.DataChangeLogExtDao;
import com.changhong.sei.datachange.dto.DataChangeLogQuickQueryParam;
import com.changhong.sei.datachange.entity.DataChangeLog;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现功能: 数据变更历史数据访问扩展接口实现
 *
 * @author 王锦光 wangjg
 * @version 2020-04-28 15:08
 */
public class DataChangeLogDaoImpl extends BaseEntityDaoImpl<DataChangeLog> implements DataChangeLogExtDao {
    public DataChangeLogDaoImpl(EntityManager entityManager) {
        super(DataChangeLog.class, entityManager);
    }

    /**
     * 分页查询数据变更历史
     *
     * @param queryParam 查询参数
     * @param tenantCode 租户代码
     * @return 查询结果
     */
    @Override
    public PageResult<DataChangeLog> queryByPage(DataChangeLogQuickQueryParam queryParam, String tenantCode) {
        String select = "select log ";
        String fromAndWhere = "from DataChangeLog log where log.tenantCode=:tenantCode ";
        Map<String, Object> sqlParams = new HashMap<>();
        String quickSearchValue = queryParam.getQuickSearchValue();
        sqlParams.put("tenantCode", tenantCode);
        // 限制时间段
        fromAndWhere = fromAndWhere + "and (log.operateTime between :startTime and :endTime) ";
        sqlParams.put("startTime", queryParam.getStartTime());
        sqlParams.put("endTime", queryParam.getEndTime());
        // 限制实体名称
        if (StringUtils.isNotBlank(queryParam.getEntityName())) {
            fromAndWhere = fromAndWhere + "and (log.entityName = :entityName) ";
            sqlParams.put("entityName", queryParam.getEntityName());
        }
        // 限制关键字
        if (!StringUtils.isBlank(quickSearchValue)){
            fromAndWhere = fromAndWhere + "and ((s.operatorAccount like :quickSearchValue) ";
            fromAndWhere = fromAndWhere + "or (s.operatorName like :quickSearchValue) ";
            fromAndWhere = fromAndWhere + "or (s.propertyName like :quickSearchValue) ";
            fromAndWhere = fromAndWhere + "or (s.propertyRemark like :quickSearchValue)) ";
            sqlParams.put("quickSearchValue", quickSearchValue+"%");
        }
        QuerySql querySql = new QuerySql(select, fromAndWhere);
        // 排序
        querySql.setOrderBy("order by log.operateTime desc");
        return PageResultUtil.getResult(entityManager,querySql,sqlParams, queryParam);
    }
}
