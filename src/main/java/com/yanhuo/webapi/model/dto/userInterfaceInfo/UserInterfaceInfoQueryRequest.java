package com.yanhuo.webapi.model.dto.userInterfaceInfo;

import com.yanhuo.webapi.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询用户调用接口信息请求体  查询的时候传入的值：可以根据那些字段查询
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {

    /**
     * 主键id
     */
    private Long id;

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

    /**
     * 接口状态(0-正常, 1-禁用)
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}