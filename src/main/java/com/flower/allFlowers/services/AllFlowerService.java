package com.flower.allFlowers.services;

import com.flower.allFlowers.model.AllFlower;
import com.flower.allFlowers.mapper.AllFlowerMapper;
import com.flower.allFlowers.model.FlowerRequest;
import com.flower.allFlowers.model.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by geyu on 18-1-11.
 */
@Service
@Slf4j
public class AllFlowerService {
    @Autowired
    private AllFlowerMapper allFlowerMapper;

    public ResponseResult addFlower(FlowerRequest request){
        AllFlower allFlower=new AllFlower();
        allFlower.setPicUrl(request.getPicUrl());
        allFlower.setContent(request.getContent());
        allFlower.setPrice(request.getPrice());
        allFlower.setTitle(request.getTitle());
        allFlower.setDiscount(request.getDiscount());
        allFlower.setColor(request.getColor());
        allFlower.setFestival(request.getFestival());
        allFlower.setName(request.getName());
        allFlower.setType(request.getType());

        allFlower=allFlowerMapper.save(allFlower);
       if(null==allFlower.getId()){
           log.error("全部鲜花新增失败",request);
           return ResponseResult.fail("操作失败");
       }
        return  ResponseResult.success("操作成功!");
    }

    public List<AllFlower> queryAllFlower() {
        List<AllFlower> list= allFlowerMapper.findAll();
        for(AllFlower allFlower: list){
            allFlower.setRealPrice(allFlower.getPrice().multiply(allFlower.getDiscount()));
        }
        return list;
    }

    public void deleteFlower(String id) {
        allFlowerMapper.deleteById(id);

    }

    public List<AllFlower> queryFestival(String festival) {
        List<AllFlower> list=allFlowerMapper.findByFestival(festival);
        return list;
    }
}
