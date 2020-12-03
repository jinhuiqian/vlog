package com.jinhuiqian.vlog.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 231
 * @date 2020-12-03 13:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResult {
    /**code为返回的状态码*/
    private Integer code;
    /**msg为后端给前端返回的消息*/
    private String msg;
    /**data为返回的数据（可以为空）*/
    private Object data;
}
