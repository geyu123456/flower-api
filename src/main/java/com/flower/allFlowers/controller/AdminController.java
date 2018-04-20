package com.flower.allFlowers.controller;

import com.flower.allFlowers.model.FlowerRequest;
import com.flower.allFlowers.model.ResponseResult;
import com.flower.allFlowers.services.AllFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by geyu on 18-1-29.
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController extends  BaseController {
    @Autowired
    private AllFlowerService allFlowerService;

    @RequestMapping(value = "/addFlower" ,method = RequestMethod.PUT)
    public ResponseResult addFlower(@RequestBody FlowerRequest request){

        return allFlowerService.addFlower(request);
    }

    @GetMapping( "/login")
    public  String login(){
        return  "/login";
    }
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
