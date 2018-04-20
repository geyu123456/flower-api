package com.flower.allFlowers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by geyu on 18-1-11.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {
    /**
     * 成功码
     */
    private   static final String SUCCESS_CODE="0";
    /**
     * 失败码
     */
    private  static  final String FAILURE_CODE="1";
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;
    public  static ResponseResult success(String message){
     return  new ResponseResult(SUCCESS_CODE,message);
    }
    public  static ResponseResult fail(String message){
        return new ResponseResult(FAILURE_CODE,message);
    }
}
