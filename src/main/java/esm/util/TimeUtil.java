package esm.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
   
	static Date result;

	//获取上周的日期往前推7天
	public static Date getLastWeekDateR(){

		Calendar ss = Calendar.getInstance();
		ss.add(Calendar.DATE, -7);
		result = ss.getTime();
		
		return result;
	}

	//获取上个月的日期
	public static Date getLastMonthDate(){
		
		Calendar ss = Calendar.getInstance();
		ss.add(Calendar.MONTH, -1);
		ss.set(Calendar.DATE, 1);
		result = ss.getTime();
		
		return result;
	}

	//获取上周的日期超过7天
	public static Date getLastWeekDateL(){

		Calendar ss = Calendar.getInstance();
		ss.add(Calendar.DATE, -8);
		result = ss.getTime();

		return result;
	}


}
