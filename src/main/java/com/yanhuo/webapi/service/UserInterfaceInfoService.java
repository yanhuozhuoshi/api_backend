package com.yanhuo.webapi.service;

import com.yanhuo.webapi.model.entity.InterfaceInfo;
import com.yanhuo.webapi.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ZhuDengRong
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service
* @createDate 2023-07-10 22:36:56
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 校验请求体信息 接口
     */
    void validUserInterfaceInfo(UserInterfaceInfo UserInterfaceInfo, boolean add);
    Boolean invokeCount(long userId,long interfaceInfoId);
}
