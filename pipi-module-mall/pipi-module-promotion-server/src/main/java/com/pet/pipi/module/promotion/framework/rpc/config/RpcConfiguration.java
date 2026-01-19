package com.pet.pipi.module.promotion.framework.rpc.config;

import com.pet.pipi.module.infra.api.websocket.WebSocketSenderApi;
import com.pet.pipi.module.member.api.user.MemberUserApi;
import com.pet.pipi.module.product.api.category.ProductCategoryApi;
import com.pet.pipi.module.product.api.sku.ProductSkuApi;
import com.pet.pipi.module.product.api.spu.ProductSpuApi;
import com.pet.pipi.module.system.api.social.SocialClientApi;
import com.pet.pipi.module.system.api.user.AdminUserApi;
import com.pet.pipi.module.trade.api.order.TradeOrderApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "promotionRpcConfiguration", proxyBeanMethods = false)
@EnableFeignClients(clients = {ProductSkuApi.class, ProductSpuApi.class, ProductCategoryApi.class,
        MemberUserApi.class, TradeOrderApi.class, AdminUserApi.class, SocialClientApi.class,
        WebSocketSenderApi.class})
public class RpcConfiguration {
}
