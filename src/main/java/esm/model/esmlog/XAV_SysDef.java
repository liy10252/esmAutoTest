package esm.model.esmlog;

import lombok.Data;

import java.util.Date;

@Data
public class XAV_SysDef {

	private Integer id;
	private Date Time;
	private Integer EventType;
	private Integer EventLevel;
	private String EventSource;
	private Integer Category;
	private String UserName;
	private String GUID;
	private String Description;
	private Integer result;
	private Integer deftype;
	private String source;
	private String target;
	private String action;
	private String oldvalue;
	private String newvalue;
	private Integer ruleid;
	private Integer ruleclass;
}
