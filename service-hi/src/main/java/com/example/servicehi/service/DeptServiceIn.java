package com.example.servicehi.service;




import com.collourful.api.entity.Dept;
import java.util.List;

public interface DeptServiceIn {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
