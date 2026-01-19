package com.pet.pipi.module.bpm.dal.mysql.definition;


import com.pet.pipi.framework.common.pojo.PageResult;
import com.pet.pipi.framework.mybatis.core.mapper.BaseMapperX;
import com.pet.pipi.framework.mybatis.core.query.QueryWrapperX;
import com.pet.pipi.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import com.pet.pipi.module.bpm.dal.dataobject.definition.BpmFormDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 动态表单 Mapper
 *
 * @author 风里雾里
 */
@Mapper
public interface BpmFormMapper extends BaseMapperX<BpmFormDO> {

    default PageResult<BpmFormDO> selectPage(BpmFormPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<BpmFormDO>()
                .likeIfPresent("name", reqVO.getName())
                .orderByDesc("id"));
    }

}
