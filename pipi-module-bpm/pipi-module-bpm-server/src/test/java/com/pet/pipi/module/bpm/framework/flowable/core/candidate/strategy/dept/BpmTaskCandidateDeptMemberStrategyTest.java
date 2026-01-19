package com.pet.pipi.module.bpm.framework.flowable.core.candidate.strategy.dept;

import com.pet.pipi.framework.common.util.collection.SetUtils;
import com.pet.pipi.framework.test.core.ut.BaseMockitoUnitTest;
import com.pet.pipi.module.system.api.dept.DeptApi;
import com.pet.pipi.module.system.api.user.AdminUserApi;
import com.pet.pipi.module.system.api.user.dto.AdminUserRespDTO;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Set;

import static com.pet.pipi.framework.common.pojo.CommonResult.success;
import static com.pet.pipi.framework.test.core.util.RandomUtils.randomPojo;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class BpmTaskCandidateDeptMemberStrategyTest extends BaseMockitoUnitTest {

    @InjectMocks
    private BpmTaskCandidateDeptMemberStrategy strategy;

    @Mock
    private DeptApi deptApi;
    @Mock
    private AdminUserApi adminUserApi;

    @Test
    public void testCalculateUsers() {
        // 准备参数
        String param = "10,20";
        // mock 方法
        when(adminUserApi.getUserListByDeptIds(eq(SetUtils.asSet(10L, 20L)))).thenReturn(success(asList(
                randomPojo(AdminUserRespDTO.class, o -> o.setId(11L)),
                randomPojo(AdminUserRespDTO.class, o -> o.setId(21L)))));

        // 调用
        Set<Long> userIds = strategy.calculateUsers(param);
        // 断言结果
        assertEquals(Sets.newLinkedHashSet(11L, 21L), userIds);
    }

}
