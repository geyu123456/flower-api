package com.flower.allFlowers.controller;

import com.flower.User.model.User;
import com.flower.User.service.IUserService;
import com.flower.allFlowers.model.FlowerRequest;
import com.flower.allFlowers.model.ResponseResult;
import com.flower.allFlowers.services.AllFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by geyu on 18-1-29.
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController extends  BaseController {
    @Autowired
    private AllFlowerService allFlowerService;
    @Autowired
    private IUserService userService;



    @RequestMapping(value = "/addFlower" ,method = RequestMethod.PUT)
    public ResponseResult addFlower(@RequestBody FlowerRequest request){

        return allFlowerService.addFlower(request);
    }

    @RequestMapping(value = "findAllUser",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAllUser(){
        return userService.findAllUser();



    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public ModelAndView  login(@RequestParam(value = "username") String account,
                               @RequestParam(value = "password") String password){
        ResponseResult result=userService.login(account,password);
        if(result.getCode().equals("0")){

            ModelAndView modelAndView=  new ModelAndView("/total/list");
            modelAndView.addObject(allFlowerService.queryAllFlower());
            return  modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/login");
            modelAndView.addObject("param","error");
            return  modelAndView;
        }



    }

    /*@GetMapping( "/login")
    public  String login(){
        return  "/login";
    }*/
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
