package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectSteps extends BaseClass {
	//URL
	@Given("Entering the URL")
	public void entering_the_url() {
		browseConfigChrome();
	    implicityWait();
	    openUrl("https://demoqa.com/elements");
	    maximizeWindow();
	    System.out.println("Entering the URL");
	}
	
	//Text Box
	@Given("Clicking the text box tab")
	public void clicking_the_text_box_tab() {
	    locateByXPath("//span[text()='Text Box']").click();
	    System.out.println("Text Box Test:");
	}
	@Given("Entering name {string} email {string} current address {string} permanent address {string}")
	public void entering_name_email_current_address_permanent_address(String name, String email, String caddress, String paddress) {
	    locateById("userName").sendKeys(name);
	    locateById("userEmail").sendKeys(email);
	    locateById("currentAddress").sendKeys(caddress);
	    locateById("permanentAddress").sendKeys(paddress);
	}
	@When("Clicking submit button")
	public void clicking_submit_button() throws InterruptedException {
		Thread.sleep(5000);
	    locateById("submit").click();
	}
	@When("Displaying and Verifying the Data")
	public void verifying_the_data() {
	    String name = locateByXPath("//*[@id=\"name\"]").getText();
	    System.out.println(name);
	    Assert.assertEquals(name, "Name:Ram Kumar");
	    System.out.println("Condition is Correct");
	}
	
	
	//Check Box
	@Given("Clicking the Check tab")
	public void clicking_the_check_tab() throws InterruptedException {
		implicityWait();
		locateByXPath("//span[text()='Check Box']").click();
		System.out.println("Check Box Test:");
	}
	@Given("Opening all the options")
	public void opening_all_the_options() throws InterruptedException {
		implicityWait();
	    locateByXPath("(//button[@type=\"button\"])[4]").click();
	    scrollBy();
	    locateByXPath("(//button[@type=\"button\"])[5]").click();
	    locateByXPath("(//button[@type=\"button\"])[6]").click();
	    locateByXPath("(//button[@type=\"button\"])[7]").click();
	    scrollBy();
	    locateByXPath("(//button[@type=\"button\"])[8]").click();
	    locateByXPath("(//button[@type=\"button\"])[9]").click();
	}
	@When("Selecting the Notes in Desktop, angular in workplace, General in office and entire block of downloads")
	public void selecting_the_notes_in_desktop_angular_in_workplace_general_in_office_and_entire_block_of_downloads() {
		implicityWait();
	    locateByXPath("//span[text()='Notes']").click();
	    locateByXPath("//span[text()='Angular']").click();
	    locateByXPath("//span[text()='General']").click();
	    locateByXPath("//span[text()='Downloads']").click();
	}
	@Then("Displaying the selected ones")
	public void displaying_the_selected_ones() {
	    System.out.println(locateById("result").getText());
	}
	
	//Radio Button
	@Given("Clicking Radio button")
	public void clicking_radio_button() {
		implicityWait();
		locateByXPath("//span[text()='Radio Button']").click();
		System.out.println("Radio Button Test:");
	}
	@Given("Selecting the requird option")
	public void selecting_the_requird_option() {
		implicityWait();
		scrollBy();
		locateByXPath("//label[text()='Yes']").click();
	}
	@Then("Verifying the option")
	public void verifying_the_option() {
	    SoftAssert sa = new SoftAssert();
	    sa.assertEquals(locateByXPath("//span[text()='Yes']").getText(), locateByXPath("//label[text()='Impressive']").getText());
	    if (locateByXPath("//span[text()='Yes']").getText().equals("Impressive")) {
			System.out.println("The Website is Impressive");
		} else {
			System.out.println("User says Website is not Impressive");
		}
	}
	
	//Web Tables
	@Given("Clicking Web tables")
	public void clicking_web_tables() {
		implicityWait();
		scrollBy();
		locateByXPath("//span[text()='Web Tables']").click();
	}
	@When("Adding new data to the tables name {string} lastname {string} email {string} age {string}")
	public void adding_new_data_to_the_tables_name_lastname_email_age(String name, String last, String email, String age) {
		implicityWait();
		locateById("addNewRecordButton").click();
	    locateByXPath("//input[@id=\"firstName\"]").sendKeys(name);
	    locateByXPath("//input[@id=\"lastName\"]").sendKeys(last);
	    locateByXPath("//input[@id=\"userEmail\"]").sendKeys(email);
	    locateByXPath("//input[@id=\"age\"]").sendKeys(age);
	}
	@When("Adding rest of the data salary {string} Dept {string} and submitting")
	public void adding_rest_of_the_data_salary_dept_and_submitting(String salary, String dept) throws InterruptedException {
		implicityWait();
		locateByXPath("//input[@id=\"salary\"]").sendKeys(salary);
	    locateByXPath("//input[@id=\"department\"]").sendKeys(dept);
	    locateByXPath("//button[@id=\"submit\"]").click();
	    System.out.println("New Data in table Added");
	    Thread.sleep(5000);
	}
		
	@When("Deleting one of the table data")
	public void deleting_one_of_the_table_data() {
		implicityWait();
		scrollBy();
	    locateByXPath("//span[@id=\"delete-record-2\"]").click();
	}
	@Then("Editing the exisiting data")
	public void editing_the_exisiting_data() throws AWTException, InterruptedException {
		implicityWait();
	    locateByXPath("//span[@id=\"edit-record-1\"]").click();
	    Robot r = new Robot ();
	    locateByXPath("//input[@id=\"lastName\"]").click();
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_A);
	    r.keyRelease(KeyEvent.VK_A);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    locateByXPath("//input[@id=\"lastName\"]").sendKeys("Raghu");
	    locateByXPath("//button[@id=\"submit\"]").click();
	    System.out.println("Data edited in table");
	    Thread.sleep(5000);
	}
	@Then("Searching the person data")
	public void searching_the_person_data() {
		implicityWait();
	    locateByXPath("//input[@id=\"searchBox\"]").sendKeys("Insurance");
	}
	
	//Buttons
	@Given("Clicking buttons")
	public void clicking_buttons() {
		implicityWait();
		scrollBy();
		locateByXPath("//span[text()='Buttons']").click();
		System.out.println("Buttons Test:");
	}
	@Given("Double clicking and displaying")
	public void double_clicking_and_displaying() throws InterruptedException {
	    Thread.sleep(5000);
	    scrollBy();
		Actions act = new Actions(driver);
		act.doubleClick(locateById("doubleClickBtn")).perform();
		System.out.println("Double Clicked");
	}
	@Then("Right Clicking and Displaying")
	public void right_clicking_and_displaying() {
		implicityWait();
		Actions act = new Actions(driver);
		act.contextClick(locateById("rightClickBtn")).perform();
		System.out.println("Right Clicked");
	}
	@Then("Clicking the buttons")
	public void clicking_the_buttons() {
		scrollBy();
		locateByXPath("//button[text()='Click Me']").click();
	}


	//Links
	@Given("Clicking the link")
	public void clicking_the_link() {
		implicityWait();
		scrollBy();
		locateByXPath("//span[text()='Links']").click();
		System.out.println("Links Test:");
	}
	@Given("Clicking the new tab links")
	public void clicking_the_new_tab_links() throws InterruptedException {
		implicityWait();
	    locateById("simpleLink").click();
	    locateById("dynamicLink").click();
	    System.out.println("New Tab Links Clicked");
	    Thread.sleep(5000);
	    String parent = driver.getWindowHandle();
	    driver.switchTo().window(parent);
	}
	@Then("Clicking various option links and printing")
	public void clicking_various_option_links_and_printing() {
		implicityWait();
		System.out.println("Sample Links");
		scrollBy();
	    locateById("created").click();
	    System.out.println("Clciked Created Link");
	    locateById("no-content").click();
	    locateById("moved").click();
	    System.out.println("Clciked Moved Link");
	    locateById("bad-request").click();
	    locateById("unauthorized").click();
	    System.out.println("Clciked UnAuthorized Link");
	    locateById("forbidden").click();
	    locateById("invalid-url").click();
	    System.out.println("Clicked Invalid Link");
	}
	
	//Broken link and images
	@Given("Clicking the tab link")
	public void clicking_the_tab_link() {
		implicityWait();
		scrollBy();
		locateByXPath("//span[text()='Broken Links - Images']").click();
		System.out.println("Broken link and images Test:");
	}
	@Given("Checking the image is displayed or not")
	public void checking_the_image_is_displayed_or_not() {
	    boolean a = locateByXPath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[1]").isDisplayed();
	    if (a==true) {
			System.out.println("Image is Not Broken");
		} else {
			System.out.println("Image is Broken");
		}
	    boolean b = locateByXPath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[2]").isDisplayed();
	    if (b==true) {
			System.out.println("Image is Not Broken");
		} else {
			System.out.println("Image is Broken");
		}
	}
	@Then("Cheching whether it is valid link or not")
	public void cheching_whether_it_is_valid_link_or_not() {
		String url="";
	      List<WebElement> allURLs = driver.findElements(By.tagName("a"));
	      System.out.println("Total links on the Wb Page: " + allURLs.size());

	      java.util.Iterator<WebElement> iterator = allURLs.iterator();
	      while (iterator.hasNext()) {
	    	  url = iterator.next().getText();
	    	  System.out.println(url);
	      }
	}

   //Upload and Download
	
	@Given("Clicking the uploading and downloading")
	public void clicking_the_uploading_and_downloading() {
		implicityWait();
		scrollBy();
		locateByXPath("//span[text()='Upload and Download']").click();
		System.out.println("Upload and Download Test:");
	}
	@Given("Downloading the image")
	public void downloading_the_image() {
	    locateByXPath("//a[text()='Download']").click();
	}
	@Then("Uplading the image")
	public void uplading_the_image() {
	    System.out.println("Uploading Can be done Manually");
	}
	
	//Dynamic Properties
	@Given("Clicking the dynamic properties tab")
	public void clicking_the_dynamic_properties_tab() {
		implicityWait();
		scrollBy();
		locateByXPath("//span[text()='Dynamic Properties']").click();
		System.out.println("Dynamic Properties Test:");
	}
	@Then("Displaying dynamic button text")
	public void displaying_dynamic_button_text() throws InterruptedException {
	    Thread.sleep(7000);
	    System.out.println(locateByXPath("//button[@id=\"enableAfter\"]").getText());
	    Thread.sleep(5000);
	    System.out.println(locateByXPath("//button[@id=\"visibleAfter\"]").getText());
	}
	
	
	//Quiting
	@Given("Exiting the web browser")
	public void exiting_the_web_browser() throws InterruptedException {
	    Thread.sleep(10000);
	    quitBrowser();
	}

	//Negative TC
	@Given("Entering the URL for Negative TC")
	public void entering_the_url_for_negative_tc() {
		browseConfigChrome();
	    implicityWait();
	    openUrl("https://demoqa.com/elements");
	    maximizeWindow();
	    System.out.println("Entering the URL");
	}
	@Given("Clicking the text box tab for Negative TC")
	public void clicking_the_text_box_tab_for_negative_tc() {
		 locateByXPath("//span[text()='Text Box']").click();
		 System.out.println("Negative TC Test");
	}
	@Given("Entering name {string} email {string} current address {string} permanent address {string} for Negative TC")
	public void entering_name_email_current_address_permanent_address_for_negative_tc(String name, String email, String caddress, String paddress) {
		locateById("userName").sendKeys(name);
	    locateById("userEmail").sendKeys(email);
	    locateById("currentAddress").sendKeys(caddress);
	    locateById("permanentAddress").sendKeys(paddress);
	}
	@Then("submiting the Negative TC")
	public void submiting_the_negative_tc() throws InterruptedException {
	    locateById("submit").click();
	    Thread.sleep(5000);
	    closeBrowser();
	    
	}

	



}
