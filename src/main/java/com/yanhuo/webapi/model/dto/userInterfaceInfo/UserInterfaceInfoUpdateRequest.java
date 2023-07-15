package com.yanhuo.webapi.model.dto.userInterfaceInfo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新用户调用接口的请求体:就是更新的时候需要传入那些值，
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    /**
     * 主键id
     */
    private Long id;


    /**
     * 总调用次数
     */
    private Integer totalNum;
    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 接口状态(0-正常, 1-禁用)
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}