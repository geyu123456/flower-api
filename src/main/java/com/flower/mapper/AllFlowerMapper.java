package com.flower.mapper;

import com.flower.common.mongodb.MyRepository;
import com.flower.domain.AllFlower;
import com.flower.requests.AddFlowerRequest;

/**
 * Created by geyu on 18-1-11.
 */
public interface AllFlowerMapper extends MyRepository<AllFlower,Long> {
       AllFlower save(AddFlowerRequest request);
}
