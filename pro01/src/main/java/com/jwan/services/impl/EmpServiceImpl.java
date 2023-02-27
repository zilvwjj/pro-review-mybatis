package com.jwan.services.impl;

import com.jwan.daos.EmpDao;
import com.jwan.domain.Emp;
import com.jwan.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public Emp getEmpById(Integer id) {
        return empDao.getEmpById(id);
    }

    @Override
    public List<Emp> getDidEmpByDid(Integer did) {
        return empDao.getDidEmpByDid(did);
    }
}
