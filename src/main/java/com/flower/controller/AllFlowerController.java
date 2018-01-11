package com.flower.controller;

import com.flower.requests.AddFlowerRequest;
import com.flower.response.ResponseResult;
import com.flower.services.AllFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by geyu on 18-1-11.
 */

@RestController
@Slf4j
@RequestMapping("/total")
public class AllFlowerController extends  BaseController {
    @Autowired
    private AllFlowerService allFlowerService;


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ModelAndView   list(){
        ModelAndView modelAndView=new ModelAndView("/index");
        return  modelAndView;
    }
    @RequestMapping(value = "/addFlower",method = RequestMethod.PUT)
    public ResponseResult addFlower(AddFlowerRequest request){
       return allFlowerService.addFlower(request);
    }






}
