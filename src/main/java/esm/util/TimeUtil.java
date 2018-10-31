package esm.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
   
	static Date result;

	//获取上周的日期
	public static Date getLastWeekDate(){
		
		Calendar ss = Calendar.getInstance();
		ss.add(Calendar.DATE, -7);
		result = ss.getTime();
		
		return result;
	}

	//获取上个月的日期
	public static Date getPMonthDate(){
		
		Calendar ss = Calendar.getInstance();
		ss.add(Calendar.MONTH, -1);
		ss.add(Calendar.DATE, -1);
		result = ss.getTime();
		
		return result;
	}


}
