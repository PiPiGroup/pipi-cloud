package com.pet.pipi.module.iot.controller.admin.ota;

import com.pet.pipi.framework.common.pojo.CommonResult;
import com.pet.pipi.framework.common.pojo.PageResult;
import com.pet.pipi.framework.common.util.object.BeanUtils;
import com.pet.pipi.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwareCreateReqVO;
import com.pet.pipi.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwarePageReqVO;
import com.pet.pipi.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwareRespVO;
import com.pet.pipi.module.iot.controller.admin.ota.vo.firmware.IotOtaFirmwareUpdateReqVO;
import com.pet.pipi.module.iot.dal.dataobject.ota.IotOtaFirmwareDO;
import com.pet.pipi.module.iot.dal.dataobject.product.IotProductDO;
import com.pet.pipi.module.iot.service.ota.IotOtaFirmwareService;
import com.pet.pipi.module.iot.service.product.IotProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.pet.pipi.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - IoT OTA 固件")
@RestController
@RequestMapping("/iot/ota/firmware")
@Validated
public class IotOtaFirmwareController {

    @Resource
    private IotOtaFirmwareService otaFirmwareService;
    @Resource
    private IotProductService productService;

    @PostMapping("/create")
    @Operation(summary = "创建 OTA 固件")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:create')")
    public CommonResult<Long> createOtaFirmware(@Valid @RequestBody IotOtaFirmwareCreateReqVO createReqVO) {
        return success(otaFirmwareService.createOtaFirmware(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新 OTA 固件")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:update')")
    public CommonResult<Boolean> updateOtaFirmware(@Valid @RequestBody IotOtaFirmwareUpdateReqVO updateReqVO) {
        otaFirmwareService.updateOtaFirmware(updateReqVO);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得 OTA 固件")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:query')")
    public CommonResult<IotOtaFirmwareRespVO> getOtaFirmware(@RequestParam("id") Long id) {
        IotOtaFirmwareDO firmware = otaFirmwareService.getOtaFirmware(id);
        if (firmware == null) {
            return success(null);
        }
        return success(BeanUtils.toBean(firmware, IotOtaFirmwareRespVO.class, o -> {
            IotProductDO product = productService.getProduct(firmware.getProductId());
            if (product != null) {
                o.setProductName(product.getName());
            }
        }));
    }

    @GetMapping("/page")
    @Operation(summary = "获得 OTA 固件分页")
    @PreAuthorize("@ss.hasPermission('iot:ota-firmware:query')")
    public CommonResult<PageResult<IotOtaFirmwareRespVO>> getOtaFirmwarePage(@Valid IotOtaFirmwarePageReqVO pageReqVO) {
        PageResult<IotOtaFirmwareDO> pageResult = otaFirmwareService.getOtaFirmwarePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotOtaFirmwareRespVO.class));
    }

}
