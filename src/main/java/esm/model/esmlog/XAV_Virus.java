package esm.model.esmlog;

import lombok.Data;
import java.util.Date;

@Data
public class XAV_Virus {

	private int id;
	private Date Time;
	private int EventType;
	private int EventLevel;
	private String EventSource;
	private int Category;
	private String UserName;
	private String GUID;
	private String Description;
	private long UniqueValue;
	private int taskid;
	private String taskname;
	private int appid;
	private Date findtime;
	private String filepath;
	private int virusid;
	private int engid;
	private int virusclass;
	private String virusname;
	private int treatmethod;
	private int state;
	private long ParentID;
}
