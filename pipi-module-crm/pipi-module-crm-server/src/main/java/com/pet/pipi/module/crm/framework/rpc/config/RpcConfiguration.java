package com.pet.pipi.module.crm.framework.rpc.config;

import com.pet.pipi.module.bpm.api.task.BpmProcessInstanceApi;
import com.pet.pipi.module.system.api.dept.DeptApi;
import com.pet.pipi.module.system.api.dept.PostApi;
import com.pet.pipi.module.system.api.logger.OperateLogApi;
import com.pet.pipi.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "crmRpcConfiguration", proxyBeanMethods = false)
@EnableFeignClients(clients = {AdminUserApi.class, DeptApi.class, PostApi.class,
        OperateLogApi.class,
        BpmProcessInstanceApi.class})
public class RpcConfiguration {
}
