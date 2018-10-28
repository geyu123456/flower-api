package com.flower.sync.model;

import com.flower.allFlowers.model.AllFlower;
import lombok.Data;

import java.util.List;
@Data
public class FlowerTrees {
    private  String desc;
    private List<AllFlower> flowerList;
}
