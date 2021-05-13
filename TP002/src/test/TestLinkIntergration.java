package test;


import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;


public class TestLinkIntergration {

	public static final String TESTLINK_KEY = "e66b912528dce91978d5733849254024";
	public static final String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "TP002";
	public static final String TEST_PLAN_NAME = "AutomationTestPlan";
	//public static final String TEST_CASE_NAME = "validLogin";
	public static final String BUILD_NAME = "Build01";
	public static int id;
	public static TestLinkAPIResults ex;
	public static void updateResults(String testCaseName, String exception, String result) throws TestLinkAPIException{
		TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		testLink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, result);
	}
	
	public static int getExID(int pl, int tc) {
		TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		//ex = new TestLinkAPIResults();
		//ex = testLink.getLastExecutionResult(pl, tc);
		
		return id;
	}
}
