package Connection;


import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;


public class TestLinkIntergration {

	public static final String TESTLINK_KEY = "555beb374cb296b7e051a2796ff81353";
	public static final String TESTLINK_URL = "http://localhost/testlink_1_9_20/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "TP001";
	public static final String TEST_PLAN_NAME = "AutomationTest";
	//public static final String TEST_CASE_NAME = "validLogin";
	public static final String BUILD_NAME = "Build01";
	public static int id;
	public static TestLinkAPIResults ex;
	public static void updateResults(String testCaseName, String exception, String result) throws TestLinkAPIException{
		TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, result);
	}	
}
