package esm.dataservice.esmlog;

import esm.model.esmlog.RFW_UrlInterceptLog;
import esm.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;

public class UrlInterService {

	SqlSession session;

	public UrlInterService(SqlSession session){
		this.session = session;
	}

	//更新指定GUID数据的时间为当日
	public void updateTimeDay(){
		updateUrlInterTime(new Date(),"290C002B-AD15-722D-13F0-7F695B683900");
	}

	//更新指定GUID数据的时间为上周
	public void updateTimelastWeek(){
		updateUrlInterTime(TimeUtil.getLastWeekDateR(),"290C002B-C745-46C8-2E08-1F790E43C700");
	}

	//更新指定GUID数据的时间为上月
	public void updateTimelastMonth(){
		updateUrlInterTime(TimeUtil.getLastMonthDate(),"6F2A732A-501D-5DCB-4E73-2A6F1D50CB5D");

	}


	//更新指定client的恶意网址日志时间
	public void updateUrlInterTime(Date date, String guid){

		RFW_UrlInterceptLog rfw_urlInterceptLog = new RFW_UrlInterceptLog();
		rfw_urlInterceptLog.setTime(date);
		rfw_urlInterceptLog.setGUID(guid);
		session.update("updateUrlInter",rfw_urlInterceptLog);
	}

}
