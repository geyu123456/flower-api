package com.flower.controller;


import com.flower.common.util.FileUtil;
import com.flower.domain.AllFlower;
import com.flower.requests.AddFlowerRequest;
import com.flower.response.ResponseResult;
import com.flower.services.AllFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
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
    @RequestMapping(value = "/addFlower" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addFlower(AddFlowerRequest request){
        if(request.getFile() != null){
            //String fileName = request.getFile().getOriginalFilename();
            String []lastName=request.getFile().getOriginalFilename().split("\\.");
            Date date=new Date();
            String fileName=String.valueOf(date.getTime()/1000)+"."+lastName[1];
            String filePath = "E:\\imgDownload\\";
            try {
                FileCopyUtils.copy(request.getFile().getInputStream(),new FileOutputStream(filePath+fileName));
                request.setPicUrl(filePath+fileName);
            } catch (IOException e) {
                log.error("上传失败",e);
            }
        }

        return allFlowerService.addFlower(request);
    }







}
