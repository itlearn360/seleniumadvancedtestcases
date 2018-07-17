package framework.framework.code;

import java.util.ArrayList;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.Test;

import framework.framework.bean.KeywordBean;
import framework.framework.bean.StepBean;
import framework.framework.bean.TestCaseBean;

public class ExecuteTestcase {
	private TestCaseBean testbean;
	private ArrayList<KeywordBean> keywords;
	private ArrayList<StepBean> steps;
	private StepBean stepbean = null;
	private KeywordBean keybean = null;
	private MainController con;
	private ExecutePageElement pagele = new ExecutePageElement();
	private FrameworkCustomFunctions fcf;

	
	@Test
	public void executetestcase() {
		System.out.println("afdadsadd");
		con = new MainController();
		
		testbean = con.getTestBean();
		
		keywords = testbean.getKeywordbean();
		System.out.println(keywords.size() + "size");
		WebdriverFunctions.openBrowser(testbean.getTestopenurl());
		//fcf = new FrameworkCustomFunctions();
		try {

			System.out.println(keywords);
			for (int key=0;key<keywords.size();key++) {
                    keybean = keywords.get(key);
                    
                    
				steps = keybean.getSteps();
				if(steps!=null && steps.size()>0){
				for (int st=0;st<steps.size();st++) {
					stepbean = steps.get(st);
					pagele.executeSteps(stepbean);

				}
				}else{
					pagele.executeSteps(keybean);
					
				}

			}
		} catch (NoSuchElementException e) {
			WebdriverFunctions.AlertBox("No such element present with "
					+ stepbean.getLocatetype() + "="
					+ stepbean.getLocatevalue());
			WebdriverFunctions.fail();
		} catch (NoSuchWindowException e) {
			WebdriverFunctions.AlertBox("No such window present with "
					+ stepbean.getStore_get_key() + " title");
			WebdriverFunctions.fail();
		} catch (ElementNotVisibleException e) {
			WebdriverFunctions.AlertBox("Element not visible with "
					+ stepbean.getLocatetype() + " ="
					+ stepbean.getLocatevalue());
			WebdriverFunctions.fail();
		} catch (Exception ex) {
			ex.printStackTrace();
			// CommonCodes.AlertBox(ex.getMessage());
			// CommonCodes.fail();
		}
	}
}
