package esm.dataservice.esmlog;

import esm.model.esmlog.XAV_SysDef;
import esm.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;

public class SysDefService {

	SqlSession session;

	public SysDefService(SqlSession session){
		this.session = session;
	}

	//更新指定SysDef时间为当日
	public void updateTimeDay(){
		updateSysDefTime(new Date(),"290C002B-AD15-722D-13F0-7F695B683900");
	}

	//更新指定SysDef时间为上周
	public void updateTimelastWeek(){
		updateSysDefTime(TimeUtil.getLastWeekDateL(),"290C002B-C745-46C8-2E08-1F790E43C700");
	}

	//更新指定SysDef时间为上月
	public void updateTimelastMonth(){
		updateSysDefTime(TimeUtil.getLastMonthDate(),"6F2A732A-501D-5DCB-4E73-2A6F1D50CB5D");

	}


	//更新指定client的系统加固日志时间
	public void updateSysDefTime(Date date, String guid){
		XAV_SysDef xav_sysDef = new XAV_SysDef();
		xav_sysDef.setTime(date);
		xav_sysDef.setGUID(guid);
		session.update("updateSysDef",xav_sysDef);
	}

}
