package com.flower.controller;

import com.flower.requests.FlowerRequest;
import com.flower.response.ResponseResult;
import com.flower.services.AllFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by geyu on 18-1-29.
 */
@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController extends  BaseController {
    @Autowired
    private AllFlowerService allFlowerService;

    @RequestMapping(value = "/addFlower" ,method = RequestMethod.PUT)
    public ResponseResult addFlower(@RequestBody FlowerRequest request){

        return allFlowerService.addFlower(request);
    }
}
