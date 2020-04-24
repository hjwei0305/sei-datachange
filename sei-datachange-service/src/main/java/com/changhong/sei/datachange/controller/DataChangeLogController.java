package com.changhong.sei.datachange.controller;

import com.changhong.sei.datachange.api.DataChangeLogApi;
import com.changhong.sei.datachange.dto.DataChangeLogDto;
import com.changhong.sei.datachange.entity.DataChangeLog;
import com.changhong.sei.datachange.service.DataChangeLogService;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;

/**
 * (DataChangeLog)数据变更日志API服务实现
 *
 * @author sei
 * @since 2020-04-24 10:02:46
 */
@RestController
@Api(value = "DataChangeLogApi", tags = "数据变更日志API服务")
@RequestMapping(path = "dataChangeLog", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataChangeLogController extends BaseEntityController<DataChangeLog, DataChangeLogDto> implements DataChangeLogApi {
    /**
     * 服务对象
     */
    @Autowired
    private DataChangeLogService service;

    @Override
    public BaseEntityService<DataChangeLog> getService() {
        return service;
    }

}