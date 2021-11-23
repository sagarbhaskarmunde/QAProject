package com.crm.qa.pages;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class GoogleSearchPage extends TestBase {

	
	
	@FindBy(xpath = "//input[@class='gLFyf gsfi']")
	public WebElement searchBox;
	
	@FindBy(xpath = "(//span[text()='https://www.flipkart.com/'])[1]")
	public WebElement FktestUrl;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	public WebElement btnLoginClose;
	
	@FindBy(xpath = "//a[@class='_6WOcW9 _2-k99T']")
	public WebElement optacc;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	public WebElement appliances;
	
	@FindBy(xpath = "//a[@class='_6WOcW9 _3YpNQe' and text()='Window ACs']")
	public WebElement winAc;
	
	@FindBy(xpath = "(//div[@class='_24_Dny']/following::span[text()='Add to Compare'])[2]")
	public WebElement chkBxSecProd;
	
	@FindBy(xpath = "(//div[@class='_24_Dny']/following::span[text()='Add to Compare'])[3]")
	public WebElement chkBxThrdProd;
	
	@FindBy(xpath = "(//div[@class='_24_Dny']/following::span[text()='Add to Compare'])[6]")
	public WebElement chkBxSixProd;
	
	@FindBy(xpath = "//span[text()='COMPARE']")
	public WebElement btnCompare;
	
	@FindBy(xpath = "//a[@class='_3L_M2k']")
	public WebElement lblProdName;
	
	@FindBy(xpath = "(//a[@class='_3L_M2k'])[1]")
	public WebElement lblProName;
	
	@FindBy(xpath = "(//div[@class='_30jeq3'])[1]")
	public WebElement lblPric;
	
	@FindBy(xpath = "//span[text()='Place Order']")
	public WebElement btnPlaceOrder;
	
	@FindBy(xpath = "//input[@class='cfnctZ']")
	public static WebElement txtBxDeliverTo;
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	public WebElement btnAddtoCar;
	
	@FindBy(xpath = "(//button[text()='GO TO CART'])[1]")
	public WebElement btnGoToCart;
	
	@FindBy(xpath = "//div[@class='_3gc7Vf']")
	public static WebElement drpDwnDelTo;
	
	public String searchList = "//li[@class='sbct']";
	public String results = "aajZCb";
	public String btnCLose = "//button[@class='_2KpZ6l _2doB4z']";
	public String drpDwnAppliances = "//div[text()='Appliances']";
	public String optnAc = "//a[@class='_6WOcW9 _2-k99T']";
	public String win = "//div[text()='Window ACs']";
	public String close = "_2KpZ6l _2doB4z";
	public String lblProd = "//a[@class='_3L_M2k']";
	public String lblPrice = "//div[@class='_30jeq3']";
	public String product = "";
	public String price = "";
	public String btnAddToCart = "//button[text()='ADD TO CART']";
	public String addedCartProdCount = "//a[@class='_2Kn22P gBNbID']";
	public static String prodDelivStatus = "//a[@class='_2Kn22P gBNbID']/following::div[@class='_1tBBEs']";
	public static String proddelstatIs = "(//a[@class='_2Kn22P gBNbID']/following::div[@class='_1tBBEs'])";
	public static String prodTit = "//preceding::a[@class='_2Kn22P gBNbID']";
	public static String pro = "(//a[@class='_2Kn22P gBNbID']";
	public static String proDel = "/following::div[@class='_1tBBEs'])";
	public static String pincode = "416203";
	public static String pincodeOtherCT = "560076";
	
	
	Actions action = new Actions(driver);
	Actions action1 = new Actions(driver);
	
	// Initializing the Page Objects:
	public GoogleSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void GetSearchList() {
		searchBox.sendKeys("flipkart");
		
		long end = System.currentTimeMillis() + 5000;

		while (System.currentTimeMillis() < end) {

		WebElement resultsDiv = driver.findElement(By.className(results));

		if (resultsDiv.isDisplayed()) {

		break;

			}

		}
		
		List<WebElement> searchResults = driver.findElements(By.xpath(searchList));
		int searchResultOcc = searchResults.size();
	 
		 for(WebElement elem:searchResults) { 
		 
		 System.out.println(elem.getText());
		 String textVal = elem.getText(); 	  
		 }	 
		 searchBox.sendKeys(Keys.ENTER);
		 
		 driver.get(prop.getProperty("testUrl"));	 
	}
	
	public void OpenFlipkartApp() {
		
		searchBox.sendKeys(Keys.ENTER);
		FktestUrl.click();
		
	
	}
	
	public void Product() {
		
		if(btnLoginClose.isDisplayed()) {
			btnLoginClose.click();
		}
				
		action.moveToElement(driver.findElement(By.xpath(drpDwnAppliances))).
		build().perform();
		action.moveToElement(driver.findElement(By.xpath(optnAc))).build().perform();
		optacc.sendKeys(Keys.DOWN);
		optacc.sendKeys(Keys.DOWN);		
		winAc.click();
		
		//7
		chkBxSecProd.click();
		chkBxThrdProd.click();
		chkBxSixProd.click();
		
		//8
		btnCompare.click();
		
		//9
		for(int i=1; i<=3; i++) {
			String prod = ("(" + lblProd + ")["+ i + "]").toString();
			product = driver.findElement(By.xpath(prod)).getAttribute("innerText");
			System.out.println("Product Name is : "+product);
		}
		
		
		for(int i=1; i<=3; i++) {
			String pric = ("(" + lblPrice + ")["+ i + "]").toString();
			price = driver.findElement(By.xpath(pric)).getAttribute("innerText");
			System.out.println("Product Price is : "+price);
		}
		
		//10 
		for(int i=1; i<=3; i++) {
			String addTocart = ("(" + btnAddToCart + ")["+ 1 + "]").toString();
			driver.findElement(By.xpath(addTocart)).isDisplayed();
			driver.findElement(By.xpath(addTocart)).click();
			boolean btnPresent = isElementPresent(btnPlaceOrder);

			
			driver.navigate().back();
			boolean lp = isElementPresent(lblProName);
			boolean lpr = isElementPresent(lblPric);
			
		}
		
		//11
		btnGoToCart.click();
		List<WebElement> cartProdCount = driver.findElements(By.xpath(addedCartProdCount));
		int num = cartProdCount.size();
		Assert.assertTrue(num==3);
		
		
		searchAvailabilitOfProd(pincode);
		drpDwnDelTo.click();
		searchAvailabilitOfProd(pincodeOtherCT);

	}
	
	
	
	
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}
	
	public static void searchAvailabilitOfProd(String pin) {
	
		txtBxDeliverTo.sendKeys(pin);
		txtBxDeliverTo.sendKeys(Keys.ENTER);
		
		List<WebElement> proStat = driver.findElements(By.xpath(prodDelivStatus));
		int occ = proStat.size();
		
		List<WebElement> prodLabl = driver.findElements(By.xpath(prodTit));
		int titleOcc = prodLabl.size();
		
		if(occ >= 1) {
			
			for(int i=1; i<=occ; i++) {
				
				for(int j=1; j<=titleOcc; j++) {
					
					String prodTitleIs = ("("+ prodDelivStatus +")[" + i + "]"+prodTit + "[" +j+ "]").toString();
					
					List<WebElement> prods = driver.findElements(By.xpath(prodTitleIs));
					if(prods.size()== 0) {
						System.out.println("");
					}else {
						String labelIs = driver.findElement(By.xpath(prodTitleIs)).getAttribute("innerText");
						System.out.println(labelIs);
					}
					
						String stat = (pro +"[" + i + "]" + proDel  +"[" + j + "]").toString();
						
						List<WebElement> prodsDelv = driver.findElements(By.xpath(stat));
						if(prodsDelv.size()== 0) {
							System.out.println("");
						}else {
							String labelIs = driver.findElement(By.xpath(stat)).getAttribute("innerText");
							System.out.println(labelIs);
						}		
				}
				
			}
		}
	}

}
