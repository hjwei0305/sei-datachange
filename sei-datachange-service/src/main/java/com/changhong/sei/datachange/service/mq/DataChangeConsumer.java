package com.changhong.sei.datachange.service.mq;

import com.changhong.sei.core.dto.datachange.DataHistoryRecord;
import com.changhong.sei.core.log.LogUtil;
import com.changhong.sei.core.mq.MqConsumer;
import com.changhong.sei.core.util.JsonUtils;
import com.changhong.sei.datachange.service.DataChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 实现功能: 记录数据变更的消费者
 *
 * @author 王锦光 wangjg
 * @version 2020-04-24 13:37
 */
@Component
public class DataChangeConsumer extends MqConsumer {
    @Autowired
    private DataChangeLogService service;

    /**
     * 收到的监听消息后的业务处理
     *
     * @param message 队列消息
     */
    @Override
    public void process(String message) {
        try {
            // 反序列化消息
            DataHistoryRecord record = JsonUtils.fromJson(message, DataHistoryRecord.class);
            if (Objects.isNull(record)) {
                return;
            }
            service.saveDataHistoryRecord(record);
        } catch (Exception e) {
            LogUtil.error("消息队列执行保存数据变更记录异常！", e);
        }
    }
}
