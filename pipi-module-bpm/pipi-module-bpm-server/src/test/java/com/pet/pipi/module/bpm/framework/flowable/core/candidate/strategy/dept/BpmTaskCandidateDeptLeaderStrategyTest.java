package com.pet.pipi.module.bpm.framework.flowable.core.candidate.strategy.dept;

import com.pet.pipi.framework.common.util.collection.SetUtils;
import com.pet.pipi.framework.test.core.ut.BaseMockitoUnitTest;
import com.pet.pipi.module.system.api.dept.DeptApi;
import com.pet.pipi.module.system.api.dept.dto.DeptRespDTO;
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

public class BpmTaskCandidateDeptLeaderStrategyTest extends BaseMockitoUnitTest {

    @InjectMocks
    private BpmTaskCandidateDeptLeaderStrategy strategy;

    @Mock
    private DeptApi deptApi;

    @Test
    public void testCalculateUsers() {
        // 准备参数
        String param = "10,20";
        // mock 方法
        when(deptApi.getDeptList(eq(SetUtils.asSet(10L, 20L)))).thenReturn(success(asList(
                randomPojo(DeptRespDTO.class, o -> o.setId(10L).setParentId(10L).setLeaderUserId(11L)),
                randomPojo(DeptRespDTO.class, o -> o.setId(20L).setParentId(20L).setLeaderUserId(21L)))));

        // 调用
        Set<Long> userIds = strategy.calculateUsers(param);
        // 断言结果
        assertEquals(Sets.newLinkedHashSet(11L, 21L), userIds);
    }

}
