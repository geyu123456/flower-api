package com.flower.allFlowers.mapper;

import com.flower.common.mongodb.MyRepository;
import com.flower.allFlowers.model.AllFlower;

import java.util.List;

/**
 * Created by geyu on 18-1-11.
 */
public interface AllFlowerMapper extends MyRepository<AllFlower,Long> {
       AllFlower save(AllFlower allFlower);
       List<AllFlower> findAll();

       void deleteById(String id);

       List<AllFlower> findByFestival(String festival);
       List<AllFlower> findAllFlowerByType(String type);
}
