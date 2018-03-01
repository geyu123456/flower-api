package com.flower.requests;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * Created by geyu on 18-1-11.
 */
@Data
public class AddFlowerRequest {

    /**
     * 图片存放地址
     */
    @NotEmpty(message = "必须上传一张图片")
    private  String picUrl;
    /**
     * 文字描述
     */
    private String content;
    /**
     * 单价
     */
    @NotEmpty(message = "单价不能为空")
    private BigDecimal price;

    /**
     * 折扣
     */
    @NotEmpty(message = "折扣不能为空")
    private BigDecimal   discount;
    /**
     * 花名
     */
    @NotEmpty(message = "标题不能为空")
    private  String title;
    /**
     * 颜色
     */
    @NotEmpty(message = "颜色不能为空")
    private  String color;
    /**
     * 花名
     */
    @NotEmpty(message = "花名不能为空")
    private  String  name;
    /**
     * 类型
     */
    @NotEmpty(message = "类型不能为空")
    private  String type;
    /**
     * 节日
     */
    @NotEmpty(message = "节日不能为空")
    private  String festival;


}
