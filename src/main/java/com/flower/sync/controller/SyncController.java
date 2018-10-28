package com.flower.sync.controller;

import com.flower.sync.model.ClassifyRespones;
import com.flower.sync.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SyncController {
    @Autowired
    private ClassifyService classifyService;
    @GetMapping("/classify")
    public ClassifyRespones queryClassify(){
        return classifyService.queryClassify();
    }


}
