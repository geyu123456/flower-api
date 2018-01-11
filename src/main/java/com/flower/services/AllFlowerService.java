package com.flower.services;

import com.flower.domain.AllFlower;
import com.flower.mapper.AllFlowerMapper;
import com.flower.requests.AddFlowerRequest;
import com.flower.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by geyu on 18-1-11.
 */
@Service
@Slf4j
public class AllFlowerService {
    @Autowired
    private AllFlowerMapper allFlowerMapper;
    public ResponseResult addFlower(AddFlowerRequest request){
       AllFlower allFlower= allFlowerMapper.save(request);
       if(0==allFlower.getId()){
           log.error("全部鲜花新增失败",request);
           return ResponseResult.fail("操作失败");
       }
        return  ResponseResult.success("操作成功!");
    }
}
