package com.jwan.services.impl;

import com.jwan.daos.DeptDao;
import com.jwan.domain.Dept;
import com.jwan.services.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public Dept getDeptById(Integer id) {
        return deptDao.getDeptById(id);
    }
}
