package com.yanhuo.webapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yanhuo.webapi.model.entity.InterfaceInfo;

/**
* @author ZhuDengRong
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-06-10 16:15:09
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验接口
     */

    public void validInterfaceInfo(InterfaceInfo interfaceInfo,boolean add);

}
