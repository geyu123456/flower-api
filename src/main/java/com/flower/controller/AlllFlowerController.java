package com.flower.controller;

import com.flower.respones.ResponesResult;
import com.flower.services.TotalFlowerService;
import lombok.Value;
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
public class TotalFlowerController extends  BaseController {
    @Autowired
    private TotalFlowerService totalFlowerService;


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ModelAndView   list(){
        ModelAndView modelAndView=new ModelAndView("/index");
        return  modelAndView;
    }
    @RequestMapping(value = "/addFlower",method = RequestMethod.PUT)
    public ResponesResult  addFlower(){
       return totalFlowerService.addFlower();
    }






}
