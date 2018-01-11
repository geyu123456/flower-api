package com.flower.services;

import com.flower.respones.ResponesResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by geyu on 18-1-11.
 */
@Service
@Slf4j
public class TotalFlowerService {
    public ResponesResult addFlower(){

        return  ResponesResult.success("操作成功!");
    }
}
