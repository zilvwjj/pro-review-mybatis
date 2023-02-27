package com.jwan.daos;

import com.jwan.domain.Dept;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface DeptDao {

    @Select("select * from dept where id = #{id}")
    @Results(id = "deptMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "emps", many = @Many(select = "com.jwan.daos.EmpDao.getDidEmpByDid",fetchType = FetchType.LAZY))
    })
    Dept getDeptById(Integer id);

}
