package com.yanhuo.webapi.model.dto.userInterfaceInfo;

import lombok.Data;
import java.io.Serializable;

/**
 * 添加用户调用接口的请求体
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    /**
     * 调用用户id
     */
    private Long userId;

    /**
     * 接口id
     */
    private Long interfaceId;

    /**
     * 总调用次数
     */
    private Integer totalNum;
    /**
     * 剩余调用次数
     */
    private Integer leftNum;


    private static final long serialVersionUID = 1L;
}