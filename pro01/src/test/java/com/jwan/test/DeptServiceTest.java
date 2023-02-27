package com.jwan.test;

import com.jwan.configs.SpringConfig;
import com.jwan.domain.Dept;
import com.jwan.services.impl.DeptServiceImpl;
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
public class DeptServiceTest {
    @Autowired
     private DeptServiceImpl deptService;

    @Test
    public void testGetDeptById(){
        Dept dept = deptService.getDeptById(1);
        System.out.println(dept);
//        System.out.println(dept.getEmps());
    }
}
