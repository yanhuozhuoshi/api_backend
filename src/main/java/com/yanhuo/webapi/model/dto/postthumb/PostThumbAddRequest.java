package com.yanhuo.webapi.model.dto.postthumb;

import java.io.Serializable;
import lombok.Data;

/**
 * 帖子点赞请求
 *
 * @Author 卡卡罗特
 */
@Data
public class PostThumbAddRequest implements Serializable {

    /**
     * 帖子 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}