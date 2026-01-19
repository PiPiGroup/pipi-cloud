package com.pet.pipi.module.trade.framework.rpc.config;

import com.pet.pipi.module.member.api.address.MemberAddressApi;
import com.pet.pipi.module.member.api.config.MemberConfigApi;
import com.pet.pipi.module.member.api.level.MemberLevelApi;
import com.pet.pipi.module.member.api.point.MemberPointApi;
import com.pet.pipi.module.member.api.user.MemberUserApi;
import com.pet.pipi.module.pay.api.order.PayOrderApi;
import com.pet.pipi.module.pay.api.refund.PayRefundApi;
import com.pet.pipi.module.pay.api.transfer.PayTransferApi;
import com.pet.pipi.module.pay.api.wallet.PayWalletApi;
import com.pet.pipi.module.product.api.category.ProductCategoryApi;
import com.pet.pipi.module.product.api.comment.ProductCommentApi;
import com.pet.pipi.module.product.api.sku.ProductSkuApi;
import com.pet.pipi.module.product.api.spu.ProductSpuApi;
import com.pet.pipi.module.promotion.api.bargain.BargainActivityApi;
import com.pet.pipi.module.promotion.api.bargain.BargainRecordApi;
import com.pet.pipi.module.promotion.api.combination.CombinationRecordApi;
import com.pet.pipi.module.promotion.api.coupon.CouponApi;
import com.pet.pipi.module.promotion.api.discount.DiscountActivityApi;
import com.pet.pipi.module.promotion.api.point.PointActivityApi;
import com.pet.pipi.module.promotion.api.reward.RewardActivityApi;
import com.pet.pipi.module.promotion.api.seckill.SeckillActivityApi;
import com.pet.pipi.module.system.api.notify.NotifyMessageSendApi;
import com.pet.pipi.module.system.api.social.SocialClientApi;
import com.pet.pipi.module.system.api.social.SocialUserApi;
import com.pet.pipi.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "tradeRpcConfiguration", proxyBeanMethods = false)
@EnableFeignClients(clients = {
        BargainActivityApi.class, BargainRecordApi.class, CombinationRecordApi.class,
        CouponApi.class, DiscountActivityApi.class, RewardActivityApi.class, SeckillActivityApi.class, PointActivityApi.class,
        MemberUserApi.class, MemberPointApi.class, MemberLevelApi.class, MemberAddressApi.class, MemberConfigApi.class,
        ProductSpuApi.class, ProductSkuApi.class, ProductCommentApi.class, ProductCategoryApi.class,
        PayOrderApi.class, PayRefundApi.class, PayTransferApi.class, PayWalletApi.class,
        AdminUserApi.class, NotifyMessageSendApi.class, SocialClientApi.class, SocialUserApi.class
})
public class RpcConfiguration {
}
