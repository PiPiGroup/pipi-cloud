package com.pet.pipi.module.infra.api.logger;

import com.pet.pipi.framework.common.biz.infra.logger.ApiAccessLogCommonApi;
import com.pet.pipi.framework.common.biz.infra.logger.dto.ApiAccessLogCreateReqDTO;
import com.pet.pipi.framework.common.pojo.CommonResult;
import com.pet.pipi.module.infra.service.logger.ApiAccessLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import static com.pet.pipi.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class ApiAccessLogApiImpl implements ApiAccessLogCommonApi {

    @Resource
    private ApiAccessLogService apiAccessLogService;

    @Override
    public CommonResult<Boolean> createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
        apiAccessLogService.createApiAccessLog(createDTO);
        return success(true);
    }

}
