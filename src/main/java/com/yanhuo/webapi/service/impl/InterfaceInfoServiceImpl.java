package com.yanhuo.webapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanhuo.webapi.common.ErrorCode;
import com.yanhuo.webapi.exception.BusinessException;
import com.yanhuo.webapi.mapper.InterfaceInfoMapper;
import com.yanhuo.webapi.model.entity.InterfaceInfo;
import com.yanhuo.webapi.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author ZhuDengRong
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-06-10 16:15:09
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        //Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        //Long userId = interfaceInfo.getUserId();
        //创建时 所有信息必须非空
        if(add){
            if(StringUtils.isAnyBlank(name,description,url,requestHeader,responseHeader,method)
            ){//&& status == null && userId == null
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数未填写完整");
            }
        }
        if(name.length() > 50 ){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口名称过长");
        }

    }
}




