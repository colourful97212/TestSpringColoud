package com.example.servicehi.dao;




import com.collourful.api.entity.Dept;
import java.util.List;

public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
