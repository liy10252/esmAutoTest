package esm.model.esmlog;

import lombok.Data;

import java.util.Date;

@Data
public class XAV_ScanEvent {

	private int id;
	private Date Time;
	private int EventType;
	private int EventLevel;
	private String EventSource;
	private int Category;
	private String UserName;
	private String GUID;
	private String Description;
	private int taskid;
	private String taskname;
	private int appid;
	private Date starttime;
	private int runtime;
	private int state;
	private int scanCount;
	private int virusCount;
	private int treatedCount;
	private int totalFileCount;
	private int scanFileCount;
	private int virusFielCount;
	private int treatedFileCount;
	private int reserve;
	private int virusFileCount;

}
