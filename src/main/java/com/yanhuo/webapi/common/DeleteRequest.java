package com.yanhuo.webapi.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 删除请求
 *
 * @Author 卡卡罗特
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}