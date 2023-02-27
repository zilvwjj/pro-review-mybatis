package com.jwan.daos;

import com.jwan.domain.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface EmpDao {
    //    @Select("select * from emp left join dept on emp.did = dept.id where emp.id = #{id}")
    @Select("select * from emp where emp.id = #{id}")
    @Results(id = "empMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "sex", property = "sex"),
            //1.级联方式处理映射关系 使用@Select("select * from emp left join dept on emp.did = dept.id where emp.id = #{id}")
    //            @Result(column = "id", property = "dept.id"),
    //            @Result(column = "name", property = "dept.name"),
            //2.one引用方法全名（分布查询）使用@Select("select * from emp where emp.id = #{id}")
            @Result(column = "did" ,property = "dept", one = @One(select = "com.jwan.daos.DeptDao.getDeptById",fetchType = FetchType.LAZY))
    })
    Emp getEmpById(Integer id);

    @Select("select * from emp where did = #{did}")
    @ResultMap(value = "empMap")
    List<Emp> getDidEmpByDid(Integer did);
}
