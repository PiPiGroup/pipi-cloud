package com.pet.pipi.module.iot.convert.thingmodel;

import com.pet.pipi.module.iot.controller.admin.thingmodel.vo.IotThingModelSaveReqVO;
import com.pet.pipi.module.iot.dal.dataobject.thingmodel.IotThingModelDO;
import com.pet.pipi.module.iot.dal.dataobject.thingmodel.model.ThingModelEvent;
import com.pet.pipi.module.iot.dal.dataobject.thingmodel.model.ThingModelProperty;
import com.pet.pipi.module.iot.dal.dataobject.thingmodel.model.ThingModelService;
import com.pet.pipi.module.iot.enums.thingmodel.IotThingModelTypeEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper
public interface IotThingModelConvert {

    IotThingModelConvert INSTANCE = Mappers.getMapper(IotThingModelConvert.class);

    @Mapping(target = "property", expression = "java(convertToProperty(bean))")
    @Mapping(target = "event", expression = "java(convertToEvent(bean))")
    @Mapping(target = "service", expression = "java(convertToService(bean))")
    IotThingModelDO convert(IotThingModelSaveReqVO bean);

    @Named("convertToProperty")
    default ThingModelProperty convertToProperty(IotThingModelSaveReqVO bean) {
        if (Objects.equals(bean.getType(), IotThingModelTypeEnum.PROPERTY.getType())) {
            return bean.getProperty();
        }
        return null;
    }

    @Named("convertToEvent")
    default ThingModelEvent convertToEvent(IotThingModelSaveReqVO bean) {
        if (Objects.equals(bean.getType(), IotThingModelTypeEnum.EVENT.getType())) {
            return bean.getEvent();
        }
        return null;
    }

    @Named("convertToService")
    default ThingModelService convertToService(IotThingModelSaveReqVO bean) {
        if (Objects.equals(bean.getType(), IotThingModelTypeEnum.SERVICE.getType())) {
            return bean.getService();
        }
        return null;
    }

}
