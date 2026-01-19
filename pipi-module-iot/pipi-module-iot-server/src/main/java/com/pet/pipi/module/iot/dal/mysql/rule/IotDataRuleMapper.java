package com.pet.pipi.module.iot.dal.mysql.rule;

import com.pet.pipi.framework.common.pojo.PageResult;
import com.pet.pipi.framework.mybatis.core.mapper.BaseMapperX;
import com.pet.pipi.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.pet.pipi.framework.mybatis.core.util.MyBatisUtils;
import com.pet.pipi.module.iot.controller.admin.rule.vo.data.rule.IotDataRulePageReqVO;
import com.pet.pipi.module.iot.dal.dataobject.rule.IotDataRuleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * IoT 数据流转规则 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface IotDataRuleMapper extends BaseMapperX<IotDataRuleDO> {

    default PageResult<IotDataRuleDO> selectPage(IotDataRulePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<IotDataRuleDO>()
                .likeIfPresent(IotDataRuleDO::getName, reqVO.getName())
                .eqIfPresent(IotDataRuleDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(IotDataRuleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(IotDataRuleDO::getId));
    }

    default List<IotDataRuleDO> selectListBySinkId(Long sinkId) {
        return selectList(new LambdaQueryWrapperX<IotDataRuleDO>()
                .apply(MyBatisUtils.findInSet("sink_ids", sinkId)));
    }

    default List<IotDataRuleDO> selectListByStatus(Integer status) {
        return selectList(IotDataRuleDO::getStatus, status);
    }

    default IotDataRuleDO selectByName(String name) {
        return selectOne(IotDataRuleDO::getName, name);
    }

}