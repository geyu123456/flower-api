package com.flower.controller;

import com.flower.domain.AllFlower;
import com.flower.requests.AddFlowerRequest;
import com.flower.response.ResponseResult;
import com.flower.services.AllFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by geyu on 18-1-11.
 */

@Controller
@Slf4j
@RequestMapping("/total")
public class AllFlowerController extends  BaseController {
    @Autowired
    private AllFlowerService allFlowerService;


    @RequestMapping(value = "/list")
    public ModelAndView   list(){
        ModelAndView modelAndView=new ModelAndView("allFlowers/allFlowersList");
        List<AllFlower> list=allFlowerService.queryAllFlower();
        modelAndView.addObject("list",list);
        return  modelAndView;
    }
    @RequestMapping(value = "/addFlower" ,method = RequestMethod.GET)
    public ResponseResult addFlower(@RequestBody AddFlowerRequest request){

        return allFlowerService.addFlower(request);
    }







}
