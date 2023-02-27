package com.jwan.test;

import com.jwan.configs.SpringConfig;
import com.jwan.domain.Emp;
import com.jwan.services.impl.EmpServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境对应的配置类
@ContextConfiguration(classes = {SpringConfig.class})
//@ContextConfiguration(locations={"classpath:applicationContext.xml"})//加载配置文件
public class EmpServiceTest {
    @Autowired
    private EmpServiceImpl empService;
    @Test
    public void testGetEmpById(){
//        System.out.println(empService.getEmpById(2));
        Emp empById = empService.getEmpById(2);
        System.out.println(empById.getDept());
    }

    @Test
    public void testGetDidEmpByDid(){
        System.out.println(empService.getDidEmpByDid(1));
    }
}
