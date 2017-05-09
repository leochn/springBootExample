package com.example.service;

import com.example.util.JsonResult;

public interface ApiService {
	JsonResult getAlarms(String alarmTypeId);
}
