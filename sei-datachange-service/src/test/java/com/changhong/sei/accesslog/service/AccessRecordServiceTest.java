package com.changhong.sei.accesslog.service;

import com.changhong.sei.accesslog.dto.AccessRecordFeatureResponse;
import com.changhong.sei.accesslog.dto.AccessRecordUserResponse;
import com.changhong.sei.accesslog.dto.TimePeriod;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.test.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2021-01-18 13:13
 */
public class AccessRecordServiceTest extends BaseUnitTest {

    @Autowired
    private AccessRecordService service;

    @Test
    public void getTopFeatures() {
        ResultData<List<AccessRecordFeatureResponse>> result = service.getTopFeatures("10044", "", TimePeriod.DAY_1, 10);
        System.out.println(result);
    }

    @Test
    public void getTopUsers() {
        ResultData<List<AccessRecordUserResponse>> result = service.getTopUsers("10044", "", TimePeriod.DAY_1, 10);
        System.out.println(result);
    }

    @Test
    public void getUsersByFeature() {
        ResultData<List<AccessRecordUserResponse>> result = service.getUsersByFeature("10044", "none", TimePeriod.DAY_1, 10);
        System.out.println(result);
    }

    @Test
    public void getFeaturesByUser() {
        ResultData<List<AccessRecordFeatureResponse>> result = service.getFeaturesByUser("10044", "admin", TimePeriod.DAY_1, 10);
        System.out.println(result);
    }
}