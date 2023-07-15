package com.yanhuo.webapi.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 封装id的请求类 主要用于接口的发布和下线
 */
@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}