package framework.framework.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import framework.framework.bean.ConfigBean;
import framework.framework.bean.TestCaseBean;

public class MainController {
	private static HashMap<Integer, TestCaseBean> testcases = new HashMap<Integer, TestCaseBean>();
	private static TestCaseBean testbean = null;
	private static String testid = null;
	private static String targetlink = null;
	private static HashMap<String, String> testrun = new HashMap<String, String>();
	private Framework_Config fc;
	private static HSSFSheet testsheet;
	private ArrayList<ConfigBean> config = new ArrayList<ConfigBean>();
	private FrameworkCustomFunctions fcf;
	private static String filepath = ".\\src\\framework\\config\\framework_config.xml";
	private ConfigBean configbean ;
	private static String keywordfile = null;
	private static String steps = null;

	public static void main(String[] args) {
		MainController con = new MainController();
		con.executeFramework();
	}

	public void executeFramework() {
		
        int testno=0;
		JUnitCore junit = new JUnitCore();
		fcf = new FrameworkCustomFunctions();
		try {
			InputStream is = new FileInputStream(new File(filepath));
			fc = new Framework_Config(is);
			config = fc.getFrameworkConfig();
			
			WebdriverFunctions.getDriver();
			for (int i = 0; i < config.size(); i++) {
				configbean = config.get(i);
				fcf.SetConfig(configbean);
				FileInputStream fstream = new FileInputStream(
						configbean.getTestfile());
				keywordfile = configbean.getKeywordfile();
				steps = configbean.getStepfile();
				testsheet = fcf.createsheet(fstream, 0);

				testcases = fcf.getSeleniumTestCasesDetails(testsheet);
                
				Set<Integer> testsets = testcases.keySet();
				Iterator<Integer> testrows = testsets.iterator();
				while (testrows.hasNext()) {
					testno = testrows.next();
					testbean = testcases.get(testno);
                   
					if (testbean.getTestexecutecon().equalsIgnoreCase("Yes")) {
						
						System.out.println(testbean.getKeywordbean());
						Class testclass=null;
						if(testbean.isExeuserclass()){
							testclass = Class.forName(testbean.getClassname());	
						}
						else{
							testclass = Class.forName("framework.framework.code.ExecuteTestcase");
						}
						//System.out.println(testclass.toString());
						Result test1res = junit.run(testclass);
						if (test1res.wasSuccessful()) {
							testbean.setIsrun("Pass");
						} else {
							testbean.setIsrun("Fail");
						}

					}
				testcases.put(testno, testbean);	
                
				}
                System.out.println(testcases.size());
				fcf.generateOutPut(testcases,configbean.getOpfile());
				WebdriverFunctions.closeDriver();	
			}
			

		} catch (Exception ex) {
            ex.printStackTrace();
			
			WebdriverFunctions.fail();
		}
		finally{
			try{
				Thread.sleep(3000);
			}
			catch(InterruptedException e){
				
			}
			
		}
	}
	
	public TestCaseBean getTestBean(){
		return testbean;
	}	
	
	
	
}
