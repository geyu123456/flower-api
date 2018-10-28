package com.flower.sync.service.impl;

import com.flower.allFlowers.mapper.AllFlowerMapper;
import com.flower.allFlowers.model.AllFlower;
import com.flower.common.enums.ClassifyEnum;
import com.flower.sync.model.ClassifyFlower;
import com.flower.sync.model.ClassifyRespones;
import com.flower.sync.model.FlowerTrees;
import com.flower.sync.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService{
    @Autowired
    private AllFlowerMapper mapper;
    @Override
    public ClassifyRespones queryClassify() {
        ClassifyFlower classifyFlower=new ClassifyFlower();
        FlowerTrees trees=new FlowerTrees();
        List<ClassifyFlower> flowerList=new ArrayList<>();
        for(ClassifyEnum classifyEnum: ClassifyEnum.values()){
            List<AllFlower> list= mapper.findByFestival(classifyEnum.getType().toString());
            trees.setFlowerList(list);
            trees.setDesc(classifyEnum.getDesc());
            classifyFlower.setId(classifyEnum.getType().toString());
            classifyFlower.setIndex(classifyEnum.getDesc());
            flowerList.add(classifyFlower);
        }
        ClassifyRespones respones=new ClassifyRespones();
        respones.setCode(200);
        respones.setMessage("请求成功！");
        respones.setData(flowerList);
        return respones;
    }
}
