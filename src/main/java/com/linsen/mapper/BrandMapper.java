package com.linsen.mapper;

import com.linsen.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    public List<Brand> selectAll();
    public void add(Brand brand);
    public Brand selectById(int id);
    public void updata(Brand brand);
    public void delete(int id);
}
