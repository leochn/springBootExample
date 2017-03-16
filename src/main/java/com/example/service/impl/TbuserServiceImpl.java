package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.TbuserMapper;
import com.example.pojo.Tbuser;
import com.example.service.TbuserService;

@Service
public class TbuserServiceImpl implements TbuserService {
	
	@Autowired
	private TbuserMapper tbuserMapper;

	public List<Tbuser> queryAll() {
		List<Tbuser> list = this.tbuserMapper.queryAll();
		return list;
	}

}
