package esm.dataservice.esmlog;

import esm.model.esmlog.XAV_Virus;
import esm.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;

public class VirusService {

	SqlSession session;

	public VirusService(SqlSession session){
		this.session = session;
	}

	//更新指定virus时间为当日
	public void updateTimeDay(){
		updateVirusTime(new Date(),"290C002B-AD15-722D-13F0-7F695B683900");
	}

	//更新指定virus时间为上周
	public void updateTimelastWeek(){
		updateVirusTime(TimeUtil.getLastWeekDateR(),"290C002B-C745-46C8-2E08-1F790E43C700");
	}

	//更新指定virus时间为上月
	public void updateTimelastMonth(){
		updateVirusTime(TimeUtil.getLastMonthDate(),"6F2A732A-501D-5DCB-4E73-2A6F1D50CB5D");

	}

	//更新指定virus日期字段
	public void updateVirusTime(Date date, String GUID){

		XAV_Virus virus = new XAV_Virus();
		virus.setGUID(GUID);
		virus.setTime(date);
		session.update("updateVirus",virus);
	}
}
