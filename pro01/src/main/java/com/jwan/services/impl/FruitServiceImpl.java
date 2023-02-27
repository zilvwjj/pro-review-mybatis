package com.jwan.services.impl;

import com.jwan.daos.FruitDao;
import com.jwan.domain.Fruit;
import com.jwan.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitDao fruitDao;

    @Override
    public Boolean save(Fruit fruit) {
        fruitDao.save(fruit);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        fruitDao.delete(id);
        return true;
    }

    @Override
    public Boolean update(Fruit fruit) {
        fruitDao.update(fruit);
        return true;
    }

    @Override
    public List<Fruit> findAll() {
        return fruitDao.findAll();
    }

    @Override
    public Fruit findById(Integer id) {
        return fruitDao.findById(id);
    }

    @Override
    public Integer getCount() {
        return fruitDao.getCount();
    }

    @Override
    public Map<String, Object> getFruitMap(Integer id) {
        return fruitDao.getFruitMap(id);
    }

    @Override
    public List<Map<String, Object>> getAllFruitToMap() {
        return fruitDao.getAllFruitToMap();
    }

    @Override
    public Map<String, Object> getAllFruitToMaps() {
        return fruitDao.getAllFruitToMaps();
    }

    @Override
    public List<Fruit> testMoHu(String moHu) {
        return fruitDao.testMoHu(moHu);
    }

    @Override
    public Integer deleteMore(String ids) {

        return fruitDao.deleteMore(ids);
    }

    @Override
    public List<Fruit> getAllFruit(String tableName) {
        return fruitDao.getAllFruit("fruit");
    }

    @Override
    public Integer insertFruit(Fruit fruit) {
        return fruitDao.insertFruit(fruit);
    }

    @Override
    public List<Fruit> selectByDynamicSQL(Fruit indexFruit) {
        return fruitDao.selectByDynamicSQL(indexFruit);
    }

    @Override
    public Integer insertByDynamicSQL(Fruit indexFruit) {
        return fruitDao.insertByDynamicSQL(indexFruit);
    }
}
