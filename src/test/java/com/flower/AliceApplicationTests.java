package com.flower;

import com.flower.allFlowers.model.AllFlower;
import com.flower.allFlowers.mapper.AllFlowerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AliceApplicationTests {
	@Autowired
private AllFlowerMapper allFlowerMapper;
	@Test
	public void contextLoads() {


		List<AllFlower> list=allFlowerMapper.findAll();
		System.out.print(list);
	}

}
