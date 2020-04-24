package com.changhong.sei.datachange.api;

import com.changhong.sei.datachange.dto.DataChangeLogDto;
import com.changhong.sei.core.api.BaseEntityApi;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (DataChangeLog)数据变更日志API接口
 *
 * @author sei
 * @since 2020-04-24 10:03:02
 */
@Valid
@FeignClient(name = "sei-datachange", path = "dataChangeLog")
public interface DataChangeLogApi extends BaseEntityApi<DataChangeLogDto> {

}