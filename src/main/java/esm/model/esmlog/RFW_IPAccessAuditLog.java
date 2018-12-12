package esm.model.esmlog;

import lombok.Data;

import java.util.Date;

@Data
public class RFW_IPAccessAuditLog {

	private Integer id;
	private Date Time;
	private Integer EventType;
	private Integer EventLevel;
	private String EventSource;
	private Integer Category;
	private String UserName;
	private String GUID;
	private String Description;
	private String SrcAddr;
	private Integer SrcPort;
	private String DstAddr;
	private Integer DstPort;
	private Integer Result;
	private Integer Reason;
	private Integer IsOffLine;
	private Integer Counts;
	private String RuleName;
}
