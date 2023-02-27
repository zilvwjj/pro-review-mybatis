package com.jwan.services;

import com.jwan.domain.Fruit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface FruitService {

    Boolean save(Fruit fruit);

    Boolean delete(Integer id);

    Boolean update(Fruit fruit);

    List<Fruit> findAll();

    Fruit findById(Integer id);

    Integer getCount();

    Map<String, Object> getFruitMap(Integer id);

    List<Map<String, Object>> getAllFruitToMap();

    Map<String, Object> getAllFruitToMaps();

    List<Fruit> testMoHu(String moHu);

    Integer deleteMore(String ids);

    List<Fruit> getAllFruit(String tableName);

    Integer insertFruit(Fruit fruit);

    List<Fruit> selectByDynamicSQL(Fruit indexFruit);

    Integer insertByDynamicSQL(Fruit indexFruit);
}
