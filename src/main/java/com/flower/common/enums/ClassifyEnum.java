package com.flower.common.enums;

public enum  ClassifyEnum {
    bunch(1,"花束"),box(2,"花盒"),opening(3,"开业花篮"),cources(4,"花艺课堂");
    private Integer type;
    private String desc;
    private   ClassifyEnum(int type, String desc){
        this.type=type;
        this.desc=desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
