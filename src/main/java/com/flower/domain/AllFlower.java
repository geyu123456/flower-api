package com.flower.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

}
