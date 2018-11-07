package esm.dataservice;

import esm.model.testcase.Cases;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class CasesService {

	SqlSession session;

	public CasesService(SqlSession session){
		this.session = session;
	}

	//获取所有case
	public List<Cases> getCaseList(){

		return session.selectList("selectCases");

	 }
	}

