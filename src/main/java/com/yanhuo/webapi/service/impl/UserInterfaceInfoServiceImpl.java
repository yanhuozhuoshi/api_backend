package com.yanhuo.webapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yanhuo.webapi.common.ErrorCode;
import com.yanhuo.webapi.exception.BusinessException;
import com.yanhuo.webapi.model.entity.InterfaceInfo;
import com.yanhuo.webapi.model.entity.UserInterfaceInfo;
import com.yanhuo.webapi.service.UserInterfaceInfoService;
import com.yanhuo.webapi.mapper.UserInterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author ZhuDengRong
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @createDate 2023-07-10 22:36:56
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{


    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceFnfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer status = userInterfaceInfo.getStatus();
        Date  createtime = userInterfaceInfo.getCreatetime();
        Date updatetime = userInterfaceInfo.getUpdatetime();
        Integer isdelete = userInterfaceInfo.getIsdelete();
        //创建时 所有信息必须非空
        if(add){
            if(StringUtils.isAnyBlank(id.toString(),userId.toString(),interfaceInfoId.toString(),totalNum.toString()
                    ,leftNum.toString(),status.toString(),createtime.toString(),updatetime.toString(),isdelete.toString())
            ){//&& status == null && userId == null
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数未填写完整!!");
            }
        }
        //校验用户和接口id是否输入正确
        if(userId <= 0 || interfaceInfoId  <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口或用户不存在!!");
        }
        //校验剩余次数
        if (leftNum<=0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口调用次数已用完!!");
        }
        //TODO 创建时间小于更新时间
    }

    /**
     * 用户每次调用之后调用次数加1
     * @param userId 用户id
     * @param interfaceInfoId 接口id
     * @return
     */
    @Override
    public Boolean invokeCount(long userId, long interfaceInfoId) {
        //需要做很多校验 这里只做演示
        if (userId<=0 || interfaceInfoId <=0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        updateWrapper.setSql("leftNum = leftNum-1,totalNum = totalNum +1");
        //这里其实应该添加锁

        return this.update(updateWrapper);
    }


}




