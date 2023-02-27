package com.jwan.services;

import com.jwan.domain.Emp;

import java.util.List;

public interface EmpService {
    Emp getEmpById(Integer id);

    List<Emp> getDidEmpByDid(Integer did);
}
