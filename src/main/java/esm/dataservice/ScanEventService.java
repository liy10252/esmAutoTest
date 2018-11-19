package esm.dataservice;

import esm.model.esmlog.XAV_ScanEvent;
import esm.util.TimeUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;

public class ScanEventService {

	SqlSession session;

	public ScanEventService(SqlSession session){
		this.session = session;
	}

	//更新指定未扫描时间为上周
	public void updateTimelastWeek(){
		updateScanEventTime(TimeUtil.getLastWeekDateForScan(),"290C002B-AD15-722D-13F0-7F695B683900");
	}

	//更新指定未扫描时间为上周
	public void updateTimelastMonth(){
		updateScanEventTime(TimeUtil.getLastMonthDate(),"290C002B-C745-46C8-2E08-1F790E43C700");
	}

	//更新指定client的扫描时间
	public void updateScanEventTime(Date date,String guid){
		XAV_ScanEvent xav_scanEvent = new XAV_ScanEvent();
		xav_scanEvent.setTime(date);
		xav_scanEvent.setGUID(guid);
		session.update("updateScanEvent",xav_scanEvent);

	}
}
