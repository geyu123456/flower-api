package com.flower.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigDecimal;

/**
 * Created by geyu on 18-1-11.
 */
@Data
@Document(collection = "allflower")
public class AllFlower {
    /**
     * id
     */
    @Id
    private String  id;
    /**
     * 图片存放地址
     */
    private  String picUrl;
    /**
     * 文字描述
     */
    private String content;
    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 折扣
     */
    private BigDecimal   discount;
    /**
     * 花名
     */
    private  String title;
    /**
     * 实际价格
     */
    private  BigDecimal realPrice;
    /**
     * 花名
     */
    private  String name;
    /**
     * 颜色
     */
    private  String color;
    /**
     * 0每日鲜花，1节日，2花篮，3婚庆，4特价
     */
    private  String type;
    /**
     * 0情人节，1妇女节，2母亲节，3父亲节，4七夕节，5元旦，6春节
     */
    private  String festival;



}
