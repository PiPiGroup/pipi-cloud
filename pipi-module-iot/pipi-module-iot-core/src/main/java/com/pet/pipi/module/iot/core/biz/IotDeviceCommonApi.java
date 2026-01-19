package com.pet.pipi.module.iot.core.biz;

import com.pet.pipi.framework.common.pojo.CommonResult;
import com.pet.pipi.module.iot.core.biz.dto.IotDeviceAuthReqDTO;
import com.pet.pipi.module.iot.core.biz.dto.IotDeviceGetReqDTO;
import com.pet.pipi.module.iot.core.biz.dto.IotDeviceRespDTO;

/**
 * IoT 设备通用 API
 *
 * @author haohao
 */
public interface IotDeviceCommonApi {

    /**
     * 设备认证
     *
     * @param authReqDTO 认证请求
     * @return 认证结果
     */
    CommonResult<Boolean> authDevice(IotDeviceAuthReqDTO authReqDTO);

    /**
     * 获取设备信息
     *
     * @param infoReqDTO 设备信息请求
     * @return 设备信息
     */
    CommonResult<IotDeviceRespDTO> getDevice(IotDeviceGetReqDTO infoReqDTO);

}
