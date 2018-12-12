package esm.model.esmlog;

import lombok.Data;

import java.util.Date;

@Data
public class RFW_UrlInterceptLog {

	private Integer id;
	private Date Time;
	private Integer EventType;
	private Integer EventLevel;
	private String EventSource;
	private Integer Category;
	private String UserName;
	private String GUID;
	private String Description;
	private String WebSite;
	private String URL;
	private Integer Result;
	private String BrowserName;
	private Integer SoftID;
}
