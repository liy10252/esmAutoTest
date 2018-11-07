package esm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import esm.model.testcase.Cases;
import java.util.List;

public class TestCaseUtil {

	public static JSONObject getParam(List<Cases> casesList,String caseName){

		for(Cases cases : casesList){
			if(caseName.contains(cases.getCasename())){
				if(cases.getParam()==null || cases.getParam() == ""){
					return null;
				}else {
					return JSON.parseObject(cases.getParam());
				}
			}
		}
		return null;
	}

	public static JSONObject getExpect(List<Cases> casesList,String caseName){

		for(Cases cases : casesList){
			if(caseName.contains(cases.getCasename())){
				if(cases.getExpect() == null || cases.getExpect() == ""){
					return null;
				}
				return JSON.parseObject(cases.getExpect());
			}
		}
		return null;
	}
}
