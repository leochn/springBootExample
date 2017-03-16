package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pojo.Tbuser;

@Mapper
public interface TbuserMapper {
	public List<Tbuser> queryAll();
}
