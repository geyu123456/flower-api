package com.flower.services;

import com.flower.requests.AddFlowerRequest;
import com.flower.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by geyu on 18-1-11.
 */
@Service
@Slf4j
public class AllFlowerService {
    public ResponseResult addFlower(AddFlowerRequest request){

        return  ResponseResult.success("操作成功!");
    }
}
