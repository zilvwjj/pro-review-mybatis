package com.jwan.daos;

import com.jwan.domain.Fruit;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface FruitDao {
//    @Insert("insert into fruit(f_name, f_price, f_count, f_remark) " +
//            "values(#{fName}, #{fPrice}, #{fCount}, #{fRemark})")
    @Insert("insert into fruit(f_name, f_price, f_count, f_remark) " +
            "values('${fName}',${fPrice}, ${fCount},'${fRemark}')")
    void save(Fruit fruit);

    @Delete("delete from fruit where f_id = #{id}")
    void delete(Integer id);

    @Update("update fruit " +
            "set f_name = #{fName}, f_price = #{fPrice}, f_count = #{fCount}, f_remark = #{fRemark}" +
            "where f_id = #{fId}")
    void update(Fruit fruit);


    @Select("select * from fruit")
    @ResultMap(value = "fruitMap")
    List<Fruit> findAll();


    @Select("select * from fruit where f_id = #{id}")
    @Results(id = "fruitMap" ,value = {
            @Result(column = "f_id", property = "fId", id = true),
            @Result(column = "f_name", property = "fName"),
            @Result(column = "f_price", property = "fPrice"),
            @Result(column = "f_count", property = "fCount"),
            @Result(column = "f_remark", property = "fRemark")
    })
    Fruit findById(Integer id);

    @Select("select count(1) from fruit")
    Integer getCount();

    @Select("select * from fruit where f_id = #{id}")
    Map<String, Object> getFruitMap(Integer id);

    @Select("select * from fruit ")
    List<Map<String, Object>> getAllFruitToMap();


    @ResultMap(value = "fruitMap")
    @Select("select * from fruit ")
    @MapKey("fId")
    Map<String, Object> getAllFruitToMaps();

    @ResultMap(value = "fruitMap")
    @Select("select * from fruit where f_name like '%${moHu}%' ")
//    @Select("select * from fruit where f_name like concat('%',#{moHu},'%') ")
    List<Fruit> testMoHu(String moHu);

    @Delete("delete from fruit where f_id in (${ids})")
    Integer deleteMore(String ids);

    @Select("select * from ${tableName}")
    @ResultMap("fruitMap")
    List<Fruit> getAllFruit(String tableName);

    @Insert(value = "insert into fruit(f_name, f_price, f_count, f_remark) values(#{fName}, #{fPrice}, #{fCount}, #{fRemark})")
    @SelectKey(statement = "select last_insert_id() From Dual" ,before = false,
    resultType = Integer.class, keyColumn = "f_id" ,keyProperty = "fId")
    Integer insertFruit(Fruit fruit);

    @SelectProvider(type = FruitDynamicSQLProvider.class, method = "select")
    @ResultMap(value = "fruitMap")
    List<Fruit> selectByDynamicSQL(Fruit indexFruit);

    @InsertProvider(type = FruitDynamicSQLProvider.class, method = "insert")
    @SelectKey(statement = "select last_insert_id() From Dual" ,before = false,
            resultType = Integer.class, keyColumn = "f_id" ,keyProperty = "fId")
    Integer insertByDynamicSQL(Fruit indexFruit);
}
