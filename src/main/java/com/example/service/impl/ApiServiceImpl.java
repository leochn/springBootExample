package com.example.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.service.ApiService;
import com.example.util.JsonResult;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ApiServiceImpl implements ApiService {

	@Override
	public JsonResult getAlarms(String alarmTypeId) {
		// java 创建json对象
		JSONArray alarmParams01 = new JSONArray();
		// 声明json对象
		JSONArray outData = new JSONArray();
		JSONObject alarmType01 = new JSONObject();
		JSONObject alarmType02 = new JSONObject();
		JSONObject alarmType03 = new JSONObject();
		JSONObject alarmType04 = new JSONObject();
		JSONObject alarmType05 = new JSONObject();
		JSONObject node = new JSONObject();
		// alarmType01
		node.put("paramId", "alarmId");
		node.put("paramDesc", "报警的ID值");
		alarmParams01.add(node);
		node.clear();
		node.put("paramId", "alarmDescription");
		node.put("paramDesc", "报警的描述");
		alarmParams01.add(node);
		node.clear();
		node.put("paramId", "deviceId");
		node.put("paramDesc", "设备编号");
		alarmParams01.add(node);
		node.clear();
		node.put("paramId", "monitor");
		node.put("paramDesc", "设备监测点名");
		alarmParams01.add(node);
		node.clear();
		node.put("paramId", "deviceName");
		node.put("paramDesc", "设备名称");
		alarmParams01.add(node);
		node.clear();
		node.put("paramId", "deviceLocation");
		node.put("paramDesc", "设备地点");
		alarmParams01.add(node);
		node.clear();
		node.put("paramId", "statusValue");
		node.put("paramDesc", "状态值");
		alarmParams01.add(node);
		node.clear();
		node.put("paramId", "alarmDescription");
		node.put("paramDesc", "报警的描述");
		alarmParams01.add(node);
		node.clear();
		alarmType01.put("alarmTypeId", "newAlarm");
		alarmType01.put("alarmTypeDesc", "设备新报警");
		alarmType01.put("alarmParams", alarmParams01);

		// alarmType02

		alarmType02.put("alarmTypeId", "newFailure");
		alarmType02.put("alarmTypeDesc", "设备新故障");
		alarmType02.put("alarmParams", alarmParams01);

		// alarmType03
		alarmType03.put("alarmTypeId", "alarmAgain");
		alarmType03.put("alarmTypeDesc", "设备再次报警");
		alarmType03.put("alarmParams", alarmParams01);

		// alarmType04
		alarmType04.put("alarmTypeId", "failureAgain");
		alarmType04.put("alarmTypeDesc", "设备再次故障");
		alarmType04.put("alarmParams", alarmParams01);

		// alarmType05
		alarmType05.put("alarmTypeId", "restore");
		alarmType05.put("alarmTypeDesc", "设备恢复正常");
		alarmType05.put("alarmParams", alarmParams01);

		if (StringUtils.isNotEmpty(alarmTypeId)) {
			if (alarmTypeId.equals("newAlarm")) {
				outData.add(alarmType01);
			} else if (alarmTypeId.equals("newFailure")) {
				outData.add(alarmType02);
			} else if (alarmTypeId.equals("alarmAgain")) {
				outData.add(alarmType03);
			} else if (alarmTypeId.equals("failureAgain")) {
				outData.add(alarmType04);
			} else if (alarmTypeId.equals("restore")) {
				outData.add(alarmType05);
			} else {

			}
		} else {
			// all
			outData.add(alarmType01);
			outData.add(alarmType02);
			outData.add(alarmType03);
			outData.add(alarmType04);
			outData.add(alarmType05);
		}
		return JsonResult.ok(outData);
	}

}
