package esm.model.esmlog;

import lombok.Data;

import java.util.Date;

@Data
public class XAV_ScanEvent {

	private Integer id;
	private Date Time;
	private Integer EventType;
	private Integer EventLevel;
	private String EventSource;
	private Integer Category;
	private String UserName;
	private String GUID;
	private String Description;
	private Integer taskid;
	private String taskname;
	private Integer appid;
	private Date starttime;
	private Integer runtime;
	private Integer state;
	private Integer scanCount;
	private Integer virusCount;
	private Integer treatedCount;
	private Integer totalFileCount;
	private Integer scanFileCount;
	private Integer virusFielCount;
	private Integer treatedFileCount;
	private Integer reserve;
	private Integer virusFileCount;

}
