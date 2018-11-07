package esm.util;

import lombok.extern.log4j.Log4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.util.Locale;
import java.util.ResourceBundle;

@Log4j
public class TestngRetry implements IRetryAnalyzer {

	public static ResourceBundle bundle = ResourceBundle.getBundle("test-config", Locale.CHINA);
	private int retryCount = 1;
	private static int maxRetryCount;

	static {
//外围文件配置最大运行次数
		maxRetryCount = Integer.parseInt(bundle.getString("maxRetryCount"));
		log.info("maxRunCount=" + (maxRetryCount));
	}

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "running retry for '" + result.getName() + "' on class " + this.getClass().getName() + " Retrying "
					+ retryCount + " times";
			log.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}
}
