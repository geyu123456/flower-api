package com.flower.controller;


import com.flower.domain.AllFlower;
import com.flower.requests.FlowerRequest;
import com.flower.response.ResponseResult;
import com.flower.services.AllFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    @Value("${picUrl}")
    private  String  filePath;


    @RequestMapping(value = "/list")
    public ModelAndView   list(){
        ModelAndView modelAndView=new ModelAndView("allFlowers/allFlowersList");
        List<AllFlower> list=allFlowerService.queryAllFlower();
        modelAndView.addObject("list",list);
        return  modelAndView;
    }
    @RequestMapping(value = "/festivalList")
    public  ModelAndView festivalList(@RequestParam String festival){
        ModelAndView modelAndView=new ModelAndView("allFlowers/allFlowersList");
        List<AllFlower> list=allFlowerService.queryFestival(festival);
        modelAndView.addObject("list",list);
        return  modelAndView;

    }

    /**
     * 新增鲜花
     * @param request
     * @return
     */
    @RequestMapping(value = "/addFlower" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addFlower(FlowerRequest request){
        if(request.getFile() != null){
            //String fileName = request.getFile().getOriginalFilename();
            String []lastName=request.getFile().getOriginalFilename().split("\\.");
            Date date=new Date();
            String fileName=String.valueOf(date.getTime()/1000)+"."+lastName[1];

            try {
                FileCopyUtils.copy(request.getFile().getInputStream(),new FileOutputStream(filePath+fileName));
                request.setPicUrl(filePath+fileName);
            } catch (IOException e) {
                log.error("上传失败",e);
            }
        }

        return allFlowerService.addFlower(request);
    }

    /**
     * 删除鲜花
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteFlower/{id}",method = RequestMethod.GET)
    public ModelAndView deleteFlower(@PathVariable("id")String id){
          allFlowerService.deleteFlower(id);
          return  list();

    }

    /**
     * 文件下载
     * @param res
     */
    @RequestMapping(value = "/downloadImg", method = RequestMethod.GET)
    public String downloadImg(HttpServletResponse res,@RequestParam String picUrl) {
        String fileName = "upload.jpg";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(picUrl)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }








}
