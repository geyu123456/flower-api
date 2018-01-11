package com.flower.common.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by geyu on 18-1-10.
 */
@Data
@ConfigurationProperties
public class ConfigBean {

    private  String MongoUrl;

    private  String port;
}
