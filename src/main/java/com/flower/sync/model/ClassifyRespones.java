package com.flower.sync.model;

import lombok.Data;

import java.util.List;

@Data
public class ClassifyRespones {
    private  Integer code;
    private String message;
    private List<ClassifyFlower> data;

}
