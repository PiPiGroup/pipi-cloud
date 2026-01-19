package com.pet.pipi.module.iot.controller.admin.product.vo.product;

import com.pet.pipi.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - IoT 产品分页 Request VO")
@Data
public class IotProductPageReqVO extends PageParam {

    @Schema(description = "产品名称", example = "李四")
    private String name;

    @Schema(description = "产品标识")
    private String productKey;

}