package com.flower.requests;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
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
    private BigDecimal   discount;
    /**
     * 花名
     */
    @NotEmpty(message = "标题不能为空")
    private  String title;


}
