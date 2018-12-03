package esm.model.testcase;

import lombok.Data;

@Data
public class Cases {

	private Integer id;
	private String casename;
	private String param;
	private String expect;
}
