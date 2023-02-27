package com.jwan.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jwan.configs.SpringConfig;
import com.jwan.domain.Fruit;
import com.jwan.services.impl.FruitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.print.Pageable;
import java.util.HashMap;

//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境对应的配置类
@ContextConfiguration(classes = {SpringConfig.class})
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})//加载配置文件
public class FruitServiceTest {
    @Autowired
    private FruitServiceImpl fruitService;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactory;
    @Test
    public void testFindById(){
        System.out.println(fruitService.findById(1));
    }

    @Test
    public void testFindAll(){
        PageHelper.startPage(2, 10);
//        System.out.println(fruitService.findAll());
        PageInfo pageInfo = new PageInfo(fruitService.findAll(), 3);
        System.out.println(pageInfo);
    }

    @Test
    public void testSave(){
        System.out.println(fruitService.save(new Fruit(2,"聂晚饭",2,21,"很好吃")));
    }

    @Test
    public void testDelete(){
        System.out.println(fruitService.delete(83));
    }

    @Test
    public void testUpdate(){
        System.out.println(fruitService.update(new Fruit(82,"测试update",2,21,"success")));
    }

    @Test
    public void testGetCount(){
        System.out.println(fruitService.getCount());
    }

    @Test
    public void testGetFruitMap(){
        System.out.println(fruitService.getFruitMap(10));
    }

    @Test
    public void testGetAllFruitToMap(){

        System.out.println(fruitService.getAllFruitToMap());
    }

    @Test
    public void testGetAllFruitToMaps(){
        System.out.println(fruitService.getAllFruitToMaps());
    }

    @Test
    public void testMoHu(){
        System.out.println(fruitService.testMoHu("瓜"));
    }

    @Test
    public void testDeleteMore(){
        System.out.println(fruitService.deleteMore("90,91,92"));
    }

    @Test
    public void testGetAllFruit(){
        System.out.println(fruitService.getAllFruit("fruit"));
    }

    @Test
    public void testInsertFruit(){
        Fruit fruit = new Fruit(2, "聂晚饭", 2, 21, "很好吃");
        System.out.println(fruitService.insertFruit(fruit));
        System.out.println(fruit.getfId());
    }

    @Test
    public void testSelectDynamicSQL(){
        System.out.println(
                fruitService.selectByDynamicSQL(
                        new Fruit(null,"瓜",null,null,"好吃")
                )
        );
    }

    @Test
    public void testInsertDynamicSQL(){
        Fruit fruit = new Fruit(null, "瓜", null, null, "好吃");
        System.out.println(
                fruitService.insertByDynamicSQL(
                        fruit
                )
        );
        System.out.println(fruit);
    }
}
