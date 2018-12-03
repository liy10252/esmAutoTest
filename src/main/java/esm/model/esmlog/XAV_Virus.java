package esm.model.esmlog;

import lombok.Data;
import java.util.Date;

@Data
public class XAV_Virus {

	private Integer id;
	private Date Time;
	private Integer EventType;
	private Integer EventLevel;
	private String EventSource;
	private Integer Category;
	private String UserName;
	private String GUID;
	private String Description;
	private long UniqueValue;
	private Integer taskid;
	private String taskname;
	private Integer appid;
	private Date findtime;
	private String filepath;
	private Integer virusid;
	private Integer engid;
	private Integer virusclass;
	private String virusname;
	private Integer treatmethod;
	private Integer state;
	private long ParentID;
}
