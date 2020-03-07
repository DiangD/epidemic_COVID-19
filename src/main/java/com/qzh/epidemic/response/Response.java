package com.qzh.epidemic.response;

import lombok.*;

/**
 * @ClassName Response
 * @Author DiangD
 * @Date 2020/3/3
 * @Version 1.0
 * @Description 接口返回的数据封装
 **/
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Response {
    @NonNull
    private Boolean success;
    @NonNull
    private String message;
    private Object body;
}
