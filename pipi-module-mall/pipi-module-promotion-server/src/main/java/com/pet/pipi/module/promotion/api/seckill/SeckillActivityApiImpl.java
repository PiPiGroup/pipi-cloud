package com.pet.pipi.module.promotion.api.seckill;

import com.pet.pipi.framework.common.pojo.CommonResult;
import com.pet.pipi.module.promotion.api.seckill.dto.SeckillValidateJoinRespDTO;
import com.pet.pipi.module.promotion.service.seckill.SeckillActivityService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import static com.pet.pipi.framework.common.pojo.CommonResult.success;

/**
 * 秒杀活动接口 Api 接口实现类
 *
 * @author HUIHUI
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class SeckillActivityApiImpl implements SeckillActivityApi {

    @Resource
    private SeckillActivityService activityService;

    @Override
    public CommonResult<Boolean> updateSeckillStockDecr(Long id, Long skuId, Integer count) {
        activityService.updateSeckillStockDecr(id, skuId, count);
        return success(true);
    }

    @Override
    public CommonResult<Boolean> updateSeckillStockIncr(Long id, Long skuId, Integer count) {
        activityService.updateSeckillStockIncr(id, skuId, count);
        return success(true);
    }

    @Override
    public CommonResult<SeckillValidateJoinRespDTO> validateJoinSeckill(Long activityId, Long skuId, Integer count) {
        return success(activityService.validateJoinSeckill(activityId, skuId, count));
    }

}
