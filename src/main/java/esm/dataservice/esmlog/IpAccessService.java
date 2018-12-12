package esm.dataservice.esmlog;

import esm.model.esmlog.RFW_IPAccessAuditLog;
import esm.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;

public class IpAccessService {

	SqlSession session;

	public IpAccessService(SqlSession session){
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
		updateUrlInterTime(TimeUtil.getLastMonthDate(),"290C002B-A0C8-FE40-0321-7C16EAB0AE00");

	}


	//更新指定client的黑客攻击日志时间
	public void updateUrlInterTime(Date date, String guid){

		RFW_IPAccessAuditLog rfw_ipAccessAuditLog = new RFW_IPAccessAuditLog();
		rfw_ipAccessAuditLog.setTime(date);
		rfw_ipAccessAuditLog.setGUID(guid);
		session.update("updateIpAccess",rfw_ipAccessAuditLog);
	}

}
