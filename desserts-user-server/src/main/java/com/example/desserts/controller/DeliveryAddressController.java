package com.example.desserts.controller;

import com.example.desserts.domain.ResponseResult;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.model.entity.DeliveryAddress;
import com.example.desserts.service.DeliveryAddressService;
import com.example.desserts.utils.UserIdExtractor;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/deliveryAddress")
public class DeliveryAddressController {

    @Resource
    private DeliveryAddressService deliveryAddressService;

    @PostMapping("/addAddress")
    public ResponseResult addAddress(HttpServletRequest request, @RequestBody DeliveryAddress deliveryAddress) {
        Integer userId = UserIdExtractor.extractUserIdFromRequest(request);
        deliveryAddress.setUserId(userId);
        if (deliveryAddressService.addAddress(deliveryAddress) == 1) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(BusinessCode.ADDRESS_ADD_ERROR);
    }

    @PostMapping("/updateDeliveryAddress")
    public ResponseResult updateDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        if (deliveryAddressService.updateDeliveryAddress(deliveryAddress) == 1) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(BusinessCode.ADDRESS_UPDATE_ERROR);
    }

    @GetMapping("/getDeliveryAddress")
    public ResponseResult getDeliveryAddress(HttpServletRequest request) {
        Integer userId = UserIdExtractor.extractUserIdFromRequest(request);
        List<DeliveryAddress> deliveryAddressList = deliveryAddressService.selectByUserId(userId);
        if (deliveryAddressList != null) {
            return ResponseResult.okResult(deliveryAddressList);
        }
        return ResponseResult.errorResult(BusinessCode.ADDRESS_SELECT_ERROR);
    }

    @PostMapping("/deleteByDeliveryAddressId")
    public ResponseResult deleteByDeliveryAddressId(@RequestBody DeliveryAddress deliveryAddress) {
        int deliveryAddressId = deliveryAddress.getDaId();
        if (deliveryAddressService.deleteByDeliveryAddressId(deliveryAddressId) == 1) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(BusinessCode.ADDRESS_DELETE_ERROR);
    }

}
