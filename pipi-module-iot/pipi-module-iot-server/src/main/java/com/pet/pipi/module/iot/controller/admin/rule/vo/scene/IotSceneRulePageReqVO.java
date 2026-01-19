package com.pet.pipi.module.iot.controller.admin.rule.vo.scene;

import com.pet.pipi.framework.common.enums.CommonStatusEnum;
import com.pet.pipi.framework.common.pojo.PageParam;
import com.pet.pipi.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.pet.pipi.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - IoT 场景联动分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IotSceneRulePageReqVO extends PageParam {

    @Schema(description = "场景名称", example = "赵六")
    private String name;

    @Schema(description = "场景描述", example = "你猜")
    private String description;

    @Schema(description = "场景状态", example = "1")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}