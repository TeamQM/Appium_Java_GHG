package com.framework.goodhealthgateway.android.Actions;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.framework.utilities.DriverFactory;


import com.framework.goodhealthgateway.drivermanager.DriverFactory;
import com.framework.goodhealthgateway.utilities.ReportManager;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.testng.Assert.assertEquals;

public class MobileActions {

	Actions action = new Actions(DriverFactory.getInstance().getMobileDriver());
	public static final Duration DEFAULT_Screen_LOAD_WAIT = Duration.ofSeconds(10);

//	MobileActions MobileActions = new MobileActions();
String currantActivity ;

	public void sleep(int timeInMilliSec) {
		try {
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void hideKeyboard() {
		DriverFactory.getInstance().getMobileDriver().hideKeyboard();
	}

	public MobileElement swipeHorizontally(String locatorType, String viewIdentificator, String text,
			String attribute) {
		WebElement element = DriverFactory.getInstance().getMobileDriver()
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." + locatorType + "(\""
						+ viewIdentificator + "\")).setAsHorizontalList()." + "scrollIntoView(" + "new UiSelector()."
						+ attribute + "(\"" + text + "\"));"));

		List<WebElement> elements = DriverFactory.getInstance().getMobileDriver()
				.findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'language_tab')]"));

		return (MobileElement) element;

	}

	/**
	 * =============================================================================
	 * Method: waitForVisible | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 60 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	public WebElement waitForVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getMobileDriver(), 30);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * =============================================================================
	 * Method: waitForVisible | Author: Annam Deepak | Date:02 Sep 2025 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 30 sec | Parameters: element | Return: element
	 * =============================================================================
	 */
	public WebElement waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getMobileDriver(), 30);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * =============================================================================
	 * Method: isNotDisplayed | Author: Sanjoosha Mahakani | Date:03 Sep 2025 |
	 * Description: This method will find the element and returns true if element not displayed 
	 * | Parameters: locator,info | Return: boolean
	 * =============================================================================
	 */
	public boolean isNotDisplayed(By locator, String info) {
	    try {
	       // Use findElements instead of findElement to avoid NoSuchElementException
	       List<WebElement> elements = DriverFactory.getInstance().getMobileDriver().findElements(locator);

	       if (elements.isEmpty()) {
	          ReportManager.logInfo("✅ Element NOT present in DOM: " + "<b style=\"color:red;\">" + info + "</b>");
	          System.out.println("✅ Element NOT present in DOM: " + info);
	          return true; // not displayed
	       } else {
	          boolean visible = elements.get(0).isDisplayed();
	          if (!visible) {
	             ReportManager.logInfo("✅ Element present but NOT visible: " + "<b style=\"color:red;\">" + info + "</b>");
	             System.out.println("✅ Element present but NOT visible: " + info);
	             return true;
	          } else {
	             ReportManager.logInfo("❌ Element IS displayed: " + "<b style=\"color:green;\">" + info + "</b>");
	             System.out.println("❌ Element IS displayed: " + info);
	             return false;
	          }
	       }
	    } catch (Exception e) {
	       // In case anything unexpected happens, treat as not displayed
	       ReportManager.logInfo("✅ Element NOT displayed (exception caught): " + "<b style=\"color:red;\">" + info + "</b>");
	       System.out.println("✅ Element NOT displayed (exception caught): " + info);
	       return true;
	    }
	}

	/**
	 * =============================================================================
	 * Method: waitForPageToLoadViaPageSource 
	 * Author: Annam  Deepak 
	 * Date: 03 Sep 2025
	 * Description: This method waits for a page to load by continuously checking 
	 *              the page source for the presence of a dismiss button. It uses 
	 *              WebDriverWait with a timeout of 20 seconds.
	 * Parameters: None
	 * Return: boolean →true if the dismiss button is found within the timeout, 
	 *                   false otherwise.
	 * =============================================================================
	 */

	public boolean waitForPageToLoadViaPageSource() {
	    try {
	        AppiumDriver driver = DriverFactory.getInstance().getMobileDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        
	        return wait.until(dr -> {
	            String pageSource = dr.getPageSource();
	            return isDismissButtonPresent(pageSource);
	        });
	        
	    } catch (Exception e) {
	        System.out.println("Page load wait via page source failed: " + e.getMessage());
	        return false;
	    }
	}

	private boolean isDismissButtonPresent(String pageSource) {
	    if (pageSource == null || pageSource.isEmpty()) {
	        return false;
	    }
	    
	    // Check for the specific dismiss button in page source
	    // The locator: //android.view.View[@content-desc="Dismiss"]
	    boolean hasDismissButton = pageSource.contains("content-desc=\"Now you can earn rewards for staying on top of activities that support you in maintaining your weight loss.\"") ||
	                              pageSource.contains("content-desc='Now you can earn rewards for staying on top of activities that support you in maintaining your weight loss.'") ||
	                             pageSource.contains("Now you can earn rewards for staying on top of activities that support you in maintaining your weight loss.");
	    
	    System.out.println("Dismiss button present in source: " + hasDismissButton);
	    return hasDismissButton;
	}
	
	/**
	 * =============================================================================
	 * Method: waitForVisible1 | Author: Annam Deepak | Date:28 Aug 2025 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 30 sec 
	 * | Parameters: locator | 
	 * Return: boolean true if the element is visible within timeout otherwise false
	 * =============================================================================
	 */
	public boolean waitForVisible1(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getMobileDriver(), 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * =============================================================================
	 * Method: waitForVisible2 | Author: Annam Deepak | Date:01 Sep 2025 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 15 sec 
	 * | Parameters: locator | 
	 * Return: boolean true if the element is visible within timeout otherwise false
	 * =============================================================================
	 */
	public boolean waitForVisible2(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getMobileDriver(), 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * =============================================================================
	 * Method: smartClickWithVerification
	 * Author: Annam  Deepak
	 * Date: 02 Sep 2025
	 * Description: This method performs multiple click attempts on a given element 
	 *              until it disappears or the maximum number of clicks is reached. 
	 *              It waits for the element to be visible before each click and 
	 *              logs the click status using ReportManager.
	 * Parameters: 
	 *      @param locator   → The By locator of the element to click
	 *      @param info      → Descriptive info about the element (used for logging)
	 *      @param maxClicks → Maximum number of click attempts
	 * Return: void
	 * =============================================================================
	 */

	public void smartClickWithVerification(By locator, String info, int maxClicks) {
	    int successfulClicks = 0;
	    
	    for (int i = 0; i < maxClicks; i++) {
	        if (waitForVisible2(locator)) {
	            try {
	                DriverFactory.getInstance().getMobileDriver().findElement(locator).click();
	                successfulClicks++;
	                System.out.println(" Successful click #" + successfulClicks + " on: " + info);
	                Thread.sleep(800); // Wait for UI response
	                
	                if (!waitForVisible2(locator)) {
	                    System.out.println(" Element disappeared after " + successfulClicks + " clicks");
	                    break;
	                }
	                
	            } catch (Exception e) {
	                System.out.println(" Click failed on attempt " + (i + 1));
	            }
	        } else {
	            System.out.println(" Element no longer visible after " + successfulClicks + " clicks");
	            break;
	        }
	    }
	    
	    if (successfulClicks > 0) {
	        ReportManager.logInfo("Successfully performed " + successfulClicks + " clicks on " + " <b style=\"color:green;\">" + info + "</b>");
	    } else {
	        ReportManager.logInfo("Not Displayed the " + " <b style=\"color:green;\">" + info + "</b> ");
	    }
	}
	
	


	/**
	 * =============================================================================
	 * Method: isElementPresent
	 *  | Author: Annam Deepak
	 *   | Date:03 Sep 2025 |
	 * Description: This method wait for element and check for every5 seconds until the provided timeout
	 *  | Parameters: locator,timeout [in seconds]
	 *   | Return: boolean true if the element is present otherwise returns false
	 * =============================================================================
	 */
	private boolean isElementPresent(By locator, int timeoutSeconds) {
	    try {
	        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getMobileDriver(), 
	            timeoutSeconds);
	        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    }
	}
	
	/**
	 * =============================================================================
	 * Method: checkHyperLinkIsPresentOrNot
	 * Author: Annam  Deepak
	 * Date: 01 Sep 2025
	 * Description: This method checks whether a given hyperlink is present on the screen 
	 *              by locating it using the provided link text in the content-desc attribute. 
	 *              If found, it retrieves and returns the hyperlink's content description.
	 * Parameters:
	 *      @param link → The hyperlink text to search for in the content-desc attribute
	 * Return: String → The content description of the hyperlink if present, 
	 *                  otherwise an empty string
	 * =============================================================================
	 */

	public String checkHyperLinkIsPresentOrNot(String link) {
		String contentDescriptionOfLink="";
		By hyperLink = By.xpath("//android.view.View[@content-desc='" + link + "']");
		if(	  waitForVisible1(hyperLink)) {
		 contentDescriptionOfLink=	getAttribute(hyperLink, "content-desc");
		}
		return contentDescriptionOfLink;
	}

	/**
	 * =============================================================================
	 * Method: Click | Author: Rajesh Buddha | Date:16 Jan 2020 | Description: This
	 * method click on element | Parameters: locator, info | Return: none
	 * =============================================================================
	 *
	 * @throws IOException
	 */
	public void click(By locator, String info) {

		WebElement elm = waitForVisible(locator);
		ReportManager.logInfo("Successfully element displayed" + "<b style=\"color:green;\"> : " + info + "</b>");
		System.out.println("Successfully element displayed :-" + info);

		elm.click();
		ReportManager.logInfo("Successfully clicked on " + " <b style=\"color:green;\"> " + info + "</b>"+" button");
		System.out.println("Successfully clicked on - " + info);

		// ReportManager.logScreenshotInfo();

	}
	/**
	 * =============================================================================
	 * Method: click
	 * Author: Annam  Deepak
	 * Date: 03 Sep 2025
	 * Description: This method waits for a WebElement to become visible and 
	 *              performs a click action on it.
	 * Parameters:
	 *      @param element → The WebElement to be clicked
	 * Return: void
	 * =============================================================================
	 */

	public void click(WebElement element) {
		
		WebElement e=	waitForVisible(element);
		
		e.click();
		//ReportManager.logInfo("Successfully clicked on " + " <b style=\"color:green;\"> " + info + "</b>"+"button");
	}
	
	
	/**
	 * =============================================================================
	 * Method: scrollToEnd
	 * Author: Annam  Deepak
	 * Date: 29  Aug 2025
	 * Description: This method performs a vertical scroll to the end of a 
	 *              scrollable container using the provided class name.
	 * Parameters:
	 *      @param className → The class name of the scrollable UI element
	 * Return: void
	 * =============================================================================
	 */
	public void scrollToEnd(String className) {
	    try {
	        DriverFactory.getInstance().getMobileDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"" + className + "\")).scrollToEnd(5)"));
	    } catch (Exception e) {
	        System.out.println("Nothing to scroll for class: " + className);
	    }
	}
	
	
	
	/**
	 * =============================================================================
	 * Method: scrollAndCollect
	 * Author: Annam  Deepak
	 * Date: 01 Sep 2025
	 * Description: This method continuously scrolls through a scrollable container 
	 *              and collects all unique elements that match the given locator. 
	 *              It ensures no duplicate elements are added by tracking element 
	 *              identifiers in a HashSet. Scrolling continues until no new 
	 *              elements are loaded after a scroll action.
	 * Parameters:
	 *      @param locator   → The By locator used to identify target elements
	 *      @param className → The class name of the scrollable container 
	 *                         (used in UiScrollable)
	 * Return: List<WebElement> → A list of all unique elements found while scrolling
	 * =============================================================================
	 */
	
	public List<WebElement> scrollAndCollect(By locator,String className) {
	    List<WebElement> allMessages = new ArrayList<>();
	    boolean canScrollMore = true;
	    Set<String> seenElements = new HashSet<>(); 

	    while (canScrollMore) {
	        List<WebElement> visible = elements(locator);
	        System.out.println("Visible size"+visible.size());
	        for (WebElement el : visible) {
	            String elementId = getElementIdentifier(el); 
	            if (!seenElements.contains(elementId)) {
	                allMessages.add(el);
	                seenElements.add(elementId);
	            }
	        }


	            try {
	                List<WebElement> currentElements =   elements(locator);
	                if (!currentElements.isEmpty()) {
	                    WebElement lastElement = currentElements.get(currentElements.size() - 1);
	                    
	                    int beforeScroll = currentElements.size();
	                    
	                    DriverFactory.getInstance().getMobileDriver().findElement(
	                        MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"" + className + "\")).scrollForward()")
	                    );
	                    
	                    Thread.sleep(500); 
	                    List<WebElement> afterScrollElements =  elements(locator);
	                    
	                    canScrollMore = afterScrollElements.size() > beforeScroll;
	                } else {
	                    canScrollMore = false;
	                }
	            } catch (Exception ex) {
	                canScrollMore = false;
	            }
	        }

	    return allMessages;
	}

	

	private String getElementIdentifier(WebElement element) {
	    try {
	        String text = element.getText();
	        String location = element.getLocation().toString();
	        return text + "|" + location;
	    } catch (Exception e) {
	        return element.toString();
	    }
	}
	
	
	/**
	 * =============================================================================
	 * Method: scrollAndCollectByXpath
	 * Author: Annam Naga Venkata Deepak
	 * Date: 03 Sep 2025
	 * Description: This method scrolls through a mobile screen and collects all 
	 *              unique elements matching a given locator (XPath-based). It uses 
	 *              a stable identifier for deduplication and stops scrolling after 
	 *              encountering consecutive scrolls with no new elements found.
	 * Parameters:
	 *      @param locator   → The By locator (XPath) to identify target elements
	 *      @param className → The class name of the scrollable container 
	 *                         (used for UiScrollable)
	 * Return: List<WebElement> → A list of all unique elements collected
	 * =============================================================================
	 */

	public List<WebElement> scrollAndCollectByXpath(By locator, String className) {
	    List<WebElement> allElements = new ArrayList<>();
	    Set<String> seenElementIds = new HashSet<>();
	    int consecutiveNoNewElements = 0;
	    final int MAX_CONSECUTIVE_NO_NEW = 2; 

	    try {
	        while (consecutiveNoNewElements < MAX_CONSECUTIVE_NO_NEW) {
	            List<WebElement> currentElements = elements(locator);
	            int newElementsFound = 0;

	            for (WebElement element : currentElements) {
	                String elementId = getStableElementIdentifier(element);
	                if (!seenElementIds.contains(elementId)) {
	                    allElements.add(element);
	                    seenElementIds.add(elementId);
	                    newElementsFound++;
	                }
	            }

	            if (newElementsFound == 0) {
	                consecutiveNoNewElements++;
	            } else {
	                consecutiveNoNewElements = 0; 
	            }

	            if (consecutiveNoNewElements < MAX_CONSECUTIVE_NO_NEW) {
	                boolean scrollSuccess = performScroll(className);
	                if (!scrollSuccess) {
	                    break; // Can't scroll further
	                }
	                
	                waitForPotentialNewContent();
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Scroll collection interrupted: " + e.getMessage());
	    }

	    return allElements;
	}

	private String getStableElementIdentifier(WebElement element) {
	    try {
	        String text = element.getText();
	        String resourceId = element.getAttribute("resource-id");
	        String contentDesc = element.getAttribute("content-desc");
	        
	        return (text != null ? text : "") + "|" + 
	               (resourceId != null ? resourceId : "") + "|" + 
	               (contentDesc != null ? contentDesc : "");
	    } catch (StaleElementReferenceException e) {
	        return "stale-" + System.currentTimeMillis(); 
	    }
	}

	/**
	 * =============================================================================
	 * Method: performScroll
	 * Author: Annam  Deepak
	 * Date: 03 Sep 2025
	 * Description: This method performs a forward scroll action inside a scrollable 
	 *              container identified by the given class name. It uses 
	 *              UiScrollable to trigger the scroll. If the scroll fails 
	 *              (e.g., already at the end of the list), it returns false.
	 * Parameters:
	 *      @param className → The class name of the scrollable container to scroll
	 * Return: boolean → true if the scroll action is successful, 
	 *                   false if scrolling is not possible
	 * =============================================================================
	 */
	private boolean performScroll(String className) {
	    try {
	        DriverFactory.getInstance().getMobileDriver().findElement(
	            MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().className(\"" + className + "\")).scrollForward()"
	            )
	        );
	        return true;
	    } catch (Exception e) {
	        return false; // Scroll failed
	    }
	}

	/**
	 * =============================================================================
	 * Method: waitForPotentialNewContent
	 * Author: Annam  Deepak
	 * Date: 30 Aug 2025
	 * Description: This method provides a short wait (5 seconds) after a scroll 
	 *              operation to allow potential new content to load on the page. 
	 *              It uses WebDriverWait with a JavaScript condition that checks 
	 *              if the document.readyState is 'complete'. If the wait fails, 
	 *              execution continues without throwing an error.
	 * Parameters: None
	 * Return: void
	 * =============================================================================
	 */
	private void waitForPotentialNewContent() {
	    try {
	        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getMobileDriver(), 
	            5);
	        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
	    } catch (Exception e) {
	        // Continue even if wait fails
	    }
	}
	

	/**
	 * =============================================================================
	 * Method: clickIfVisible | Author: Annam Deepak | Date:29 Aug 2025 |
	 * Description: This method will check if the element is visible.It will check every 5 sec its
	 * present or not until 35 sec and performs click if the element is visible
	 *  | Parameters: locator,info | Return: void 
	 * =============================================================================
	 */
	
	
	
	  public void clickIfVisible(By locator,String info) {
	        try {
	            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getMobileDriver(),35);
	            MobileElement element = (MobileElement) wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(locator));
	            element.click();
	    		ReportManager.logInfo("Successfully clicked on " + " <b style=\"color:green;\"> " + info + "</b>"+"button");

	            System.out.println("✅ Clicked element: " + locator);
	        } catch (Exception e) {
	            System.out.println("⚠️ Element not visible, skipping: " + locator);
	    		ReportManager.logInfo("Not Displayed the App update popup. Skipping  " + " <b style=\"color:green;\"> " + info + "</b>"+"button");

	        }
	    }


	public void clickAndSendKeys(By locator,String info,String text) {

		click(locator,info);
		sendKeys(locator, text);

	}

	/**
	 * =============================================================================
	 * Method: sendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method enter text input text using element | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 *
	 * @throws IOException
	 */
	public void sendKeys(By locator, String text) {


		WebElement elm = waitForVisible(locator);
		elm.sendKeys(text);
		// ReportManager.logScreenshotInfo();
		ReportManager.logInfo("Successfully Entered text <b style=\"color:green;\"> : " + text + "</b>");
		System.out.println("Successfully Entered text - " + text);

	}

	/**
	 * =============================================================================
	 * Method: sendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method enter text input text using element | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 *
	 * @throws IOException
	 */
	public void sendKeys(By locator, String text, String info) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		elm.sendKeys(text);
		// ReportManager.logScreenshotInfo();
		ReportManager.logInfo("Successfully Entered text <b style=\"color:green;\"> : " + text + "</b>" + " in "+info+" field");
		System.out.println("Successfully Entered text - " + text);
	}

	/**
	 * =============================================================================
	 * Method: clearAndSendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method clear text in text box after that enter text using
	 * element | Parameters: locator, text | Return: none
	 * =============================================================================
	 */
	public void clearAndSendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text -<b style=\"color:green;\"> " + text + "</b>");
		// LogClass.loginfo("Successfully Entered text - " + text);
	}

	/**
	 * =============================================================================
	 * Method: clearAndSendKeys | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method clear text in text box after that enter text using
	 * element | Parameters: locator, text | Return: none
	 * =============================================================================
	 */
	public void clearAndSendKeys(By locator, String text, String info) {
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(text);
		ReportManager.logInfo(info + "<b style=\"color:green;\"> :" + text + "</b>");
		// LogClass.loginfo(info+" : " + text);
	}

	/**
	 * =============================================================================
	 * Method: getText | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method get the text of element | Parameters: locator | Return: elmText
	 * =============================================================================
	 */
	public String getText(By locator) {
		WebElement elm = waitForVisible(locator);
		String elmText = elm.getText();
		ReportManager.logInfo("Successfully get text - <b style=\"color:green;\">" + elmText + "</b>");
		System.out.println("Successfully get text - " + elmText);
		return elmText;
	}

	/**
	 * =============================================================================
	 * Method: getText | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method get the text of element | Parameters: locator | Return: elmText
	 * =============================================================================
	 */
	public String getText(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		String elmText = elm.getText();
		ReportManager.logInfo("" + info + "<b style=\"color:green;\"> :" + elmText + "</b>");
		return elmText;
	}

	/**
	 * =============================================================================
	 * Method: getText | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method get the text of element | Parameters: locator | Return: elmText
	 * =============================================================================
	 */
	public List<WebElement> elements(By locator) {
		waitForVisible(locator);
		List<WebElement> elmList = DriverFactory.getInstance().getMobileDriver().findElements(locator);
		return elmList;
	}

	/**
	 * =============================================================================
	 * Method: swipeUp | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method swipe up in mobile using touch action and enter int value number
	 * of times it should swipe| Parameters: howManySwipes | Return: none
	 * =============================================================================
	 */
	public void swipeUp(int howManySwipes) {
		Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startY = (int) (size.height * 0.70);
		int endY = (int) (size.height * 0.30);
		int startX = (size.width / 2);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction(DriverFactory.getInstance().getMobileDriver())
						.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
						.perform();
				System.out.println("swipeUp");
			}
		} catch (Exception e) {
			// print error or something
		}
	}

	/**
	 * =============================================================================
	 * Method: swipeDown | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method swipe down in mobile using touch action and enter int value
	 * number of times it should swipe| Parameters: howManySwipes | Return: none
	 * =============================================================================
	 */
	public void swipeDown(int howManySwipes) {
		// calculate coordinates for vertical swipe
		Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
		int startY = (int) (size.height * 0.70);
		int endY = (int) (size.height * 0.30);
		int startX = (size.width / 2);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction(DriverFactory.getInstance().getMobileDriver())
						.longPress(PointOption.point(startX, endY)).moveTo(PointOption.point(startX, startY)).release()
						.perform();
				System.out.println("swipeDown");
			}
		} catch (Exception e) {
			// print error or something
		}
	}

	/**
	 * =============================================================================
	 * Method: swipeRighttoLeft | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method swipe right to left in mobile using touch action and
	 * enter int value number of times it should swipe| Parameters: howManySwipes |
	 * Return: none
	 * =============================================================================
	 */
	public void swipeRightToLeft(int howManySwipes) {
		Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
		// calculate coordinates for horizontal swipe
		int startY = (int) (size.height / 2);
		int startX = (int) (size.width * 0.90);
		int endX = (int) (size.width * 0.10);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction(DriverFactory.getInstance().getMobileDriver())
						.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, startY)).release()
						.perform();

			}
		} catch (Exception e) {
			// print error or something
		}
	}

	/**
	 * =============================================================================
	 * Method: swipeLefttoRight | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method swipe left to right in mobile using touch action and
	 * enter int value number of times it should swipe| Parameters: howManySwipes |
	 * Return: none
	 * =============================================================================
	 */
	public void swipeLeftToRight(int howManySwipes) {
		Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
		// calculate coordinates for horizontal swipe
		int startY = (int) (size.height / 2);
		int startX = (int) (size.width * 0.10);
		int endX = (int) (size.width * 0.90);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				new TouchAction(DriverFactory.getInstance().getMobileDriver())
						.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, startY)).release()
						.perform();
			}
		} catch (Exception e) {
			// print error or something
		}
	}

	/**
	 * =============================================================================
	 * Method: swipeUp_FindElementClick | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method will swipe till element found and click| Parameters:
	 * howManySwipes, locator | Return: none
	 * =============================================================================
	 */
	public void swipeUpFindElementClick(int howManySwipes, By locator) throws InterruptedException {
		Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startY = (int) (size.height * 0.70);
		int endY = (int) (size.height * 0.30);
		int startX = (size.width / 2);
		Thread.sleep(3000);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				boolean isElmPresent = DriverFactory.getInstance().getMobileDriver().findElements(locator).size() > 0;
				if (isElmPresent) {
					DriverFactory.getInstance().getMobileDriver().findElement(locator).click();
					break;
				}
				new TouchAction(DriverFactory.getInstance().getMobileDriver())
						.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
						.perform();
			}
		} catch (Exception e) {
			// print error or something
		}
	}

	
	/**
	 * =============================================================================
	 * Method: swipeUp_FindElementClick1 | Author: Annam Deepak | Date:03 Sep 2025 |
	 * Description: This method will swipe till element found and click| Parameters:
	 * howManySwipes, locator | Return: boolean true if clicked otherwise false
	 * =============================================================================
	 */
	public boolean swipeUpFindElementClick1(int howManySwipes, By locator) throws InterruptedException {
		Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
	    AppiumDriver driver = DriverFactory.getInstance().getMobileDriver();

		boolean isClicked=false;
		// calculate coordinates for vertical swipe
		int startY = (int) (size.height * 0.70);
		int endY = (int) (size.height * 0.30);
		int startX = (size.width / 2);
		Thread.sleep(3000);
		try {
			for (int i = 1; i <= howManySwipes; i++) {
				boolean isElmPresent = DriverFactory.getInstance().getMobileDriver().findElements(locator).size() > 0;
				if (isElmPresent) {
					DriverFactory.getInstance().getMobileDriver().findElement(locator).click();
					isClicked=true;
					break;
				}
//				new TouchAction(DriverFactory.getInstance().getMobileDriver())
//						.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
//						.perform();
				  PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		            Sequence swipe = new Sequence(finger, 1);
		            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
		            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		            driver.perform(Arrays.asList(swipe));


		            Thread.sleep(1000);
			}
		} catch (Exception e) {
			// print error or something
		}
		return isClicked;
	}
	
	
	/**
	 * =============================================================================
	 * Method: swipeUpAndCollectMessageCount
	 * Author: Annam Deepak
	 * Date: 01 Sep 2025
	 * Description: This method will swipe up and collect the message count
	 * Parameters:
	 *      @param howManySwipes   → we need to mention the value to swipe how many times
	 *      @param locator  → We need to provide the locator
	 * Return: int → size of the list
	 * =============================================================================
	 */
	public int swipeUpAndCollectMessageCount(int howManySwipes, By locator) throws InterruptedException {
	    AppiumDriver driver = DriverFactory.getInstance().getMobileDriver();
	    Dimension size = driver.manage().window().getSize();
	    
	    Set<String> uniqueMessages = new HashSet<>();
	    
	    int startY = (int) (size.height * 0.70);
	    int endY = (int) (size.height * 0.30);
	    int startX = (size.width / 2);
	    
	    Thread.sleep(3000);
	    
	    try {
	        for (int i = 0; i <= howManySwipes; i++) {
	            // Wait for elements to be present and visible
	         //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            List<WebElement> elements = elements(locator);//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	            
	            for (WebElement el : elements) {
	                try {
	                    String messageContent = el.getAttribute("content-desc");
	                    if (messageContent != null && !messageContent.trim().isEmpty()) {
	                        uniqueMessages.add(messageContent.trim());
	                    } else {
	                        // Fallback to text if content-desc is empty
	                        String text = el.getText();
	                        if (text != null && !text.trim().isEmpty()) {
	                            uniqueMessages.add(text.trim());
	                        }
	                    }
	                } catch (StaleElementReferenceException e) {
	                    // Element became stale, skip and continue
	                    continue;
	                }
	            }
	            
	            if (i < howManySwipes) {
	                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	                Sequence swipe = new Sequence(finger, 1);
	                swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	                swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), startX, endY));
	                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	                driver.perform(Arrays.asList(swipe));
	                
	                // Wait for content to load after swipe
	                Thread.sleep(1500);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    // Debug output
	    System.out.println("Unique messages found: " + uniqueMessages);
	    System.out.println("Total unique count: " + uniqueMessages.size());
	    
	    return uniqueMessages.size();
	}
	
	/**
	 * =============================================================================
	 * Method: scrollUntilElementFound
	 * Author: Annam  Deepak
	 * Date: 01 Sep 2025
	 * Description: This method scrolls through a scrollable container until an 
	 *              element matching the given text or content description is found. 
	 *              It uses Android UiScrollable with either descriptionContains 
	 *              or textContains depending on the flag provided.
	 * Parameters:
	 *      @param value   → The partial text or description to search for
	 *      @param isDesc  → true to match using content-desc (descriptionContains),
	 *                       false to match using visible text (textContains)
	 * Return: WebElement → The first matching element if found, otherwise null
	 * =============================================================================
	 */
	  public  WebElement scrollUntilElementFound( String value, boolean isDesc) {
	        String uiSelector;

	        if (isDesc) {
	            uiSelector = String.format(
	                "new UiScrollable(new UiSelector().scrollable(true))" +
	                ".scrollIntoView(new UiSelector().descriptionContains(\"%s\"))", value
	            );
	        } else {
	            uiSelector = String.format(
	                "new UiScrollable(new UiSelector().scrollable(true))" +
	                ".scrollIntoView(new UiSelector().textContains(\"%s\"))", value
	            );
	        }

	        try {
	        return DriverFactory.getInstance().getMobileDriver().findElement(MobileBy.AndroidUIAutomator(uiSelector));
	        }
	        catch(Exception e) {
	        	return null;
	        }
	    }


	public void swipeElementAndroid1(By locator, String dir, By toLocator, int count) {
		System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions
		final int ANIMATION_TIME = 100; // ms
		final int PRESS_TIME = 100; // ms
		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;
		WebElement el = DriverFactory.getInstance().getMobileDriver().findElement(locator);
		// init screen variables
		Rectangle rect = el.getRect();
		// sometimes it is needed to configure edgeBorders
		// you can also improve borders to have vertical/horizontal
		// or left/right/up/down border variables
		edgeBorder = 0;
		WebElement elm = waitForVisible(toLocator);

		switch (dir) {

			case "DOWN": // from up to down
				pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
				pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
				break;
			case "UP": // from down to up
				pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
				pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
				break;
			case "LEFT": // from right to left
				pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
				pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
				break;
			case "RIGHT": // from left to right
				pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
				pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
				break;
			default:
				throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
		}
		// execute swipe using TouchAction
		try {

			for (int i = 0; i < count; i++) {
				boolean isToLocator = DriverFactory.getInstance().getMobileDriver().findElements(toLocator).size() > 0;
				if (!isToLocator) {
					System.out.println(i);
					new TouchAction(DriverFactory.getInstance().getMobileDriver()).press(pointOptionStart)
							// a bit more reliable when we add small wait
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd)
							.release().tap(tapOptions().withElement(element(elm)))
							//.release().perform().tap(tapOptions().withElement(element(elm)))
							.perform();;
				} else {
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
			return;
		}
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {

		}
	}

	/**
	 * =============================================================================
	 * Method: swipeUp_FindElementClick | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method will swipe till element found and click| Parameters:
	 * howManySwipes, locator | Return: none
	 * =============================================================================
	 */
	public void swipeUpFindElement(int howManySwipes, By locator) throws InterruptedException {
		Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startY = (int) (size.height * 0.70);
		int endY = (int) (size.height * 0.30);
		int startX = (size.width / 2);
		try {
			for (int i = 1; i <= howManySwipes; i++) {

				boolean isElmPresent = DriverFactory.getInstance().getMobileDriver().findElements(locator).size() > 0;
				if (isElmPresent) {
					// DriverFactory.getInstance().getMobileDriver().findElement(locator).click();
					break;
				}
				new TouchAction(DriverFactory.getInstance().getMobileDriver())
						.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release()
						.perform();
				System.out.println("swipeUp");
			}
		} catch (Exception e) {
			// print error or something
		}
	}
	
	
	
	


	public boolean isElmPresent(By locator) {
		boolean isElmPresent = DriverFactory.getInstance().getMobileDriver().findElements(locator).size() > 0;
		return isElmPresent;
	}


	/**
	 * =============================================================================
	 * Method: pressKeyboardValues | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method meant for static wait | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 *
	 * @throws InterruptedException
	 */
	public void pressKeyboardValues(Keys value) throws InterruptedException {
		action.sendKeys(value).build().perform();
		ReportManager.logInfo("Successfully performed keyboard action - <b style=\"color:green;\">" + value + "</b>");
		// LogClass.loginfo("Successfully performed keyboard action - " + value);
	}

	/**
	 * =============================================================================
	 * Method: getText | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * This method get the text of element | Parameters: locator | Return: elmText
	 * =============================================================================
	 */
	public int getInt(By locator) {
		WebElement elm = waitForVisible(locator);
		String elmText = elm.getText();
		int elmIntTxt = Integer.parseInt(elmText);
		ReportManager.logInfo("Successfully get Integer text - <b style=\"color:green;\">" + elmIntTxt + "</b>");
		System.out.println("Successfully get Integer text- " + elmIntTxt);
		return elmIntTxt;
	}

	/**
	 * =============================================================================
	 * Method: clickUsingCoordinates | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method right To Left Swipe Using Element | Parameters:
	 * locator, text | Return: none
	 * =============================================================================
	 *
	 * @throws InterruptedException
	 */
	public void clickUsingCoordinates(int xcordinate, int ycordinate) throws InterruptedException {
		new TouchAction(DriverFactory.getInstance().getMobileDriver()).tap(PointOption.point(xcordinate, ycordinate))
				.release().perform();

	}
	
	public void dismissPopupUsingEscapeButton() {
	
	 AppiumDriver driver = DriverFactory.getInstance().getMobileDriver();
     
     if (driver instanceof AndroidDriver) {
         AndroidDriver androidDriver = (AndroidDriver) driver;
         
         // Try ESCAPE first (most effective for popups)
         androidDriver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
         
         System.out.println("Pressed ESCAPE button");
     }
     }

	/**
	 * =============================================================================
	 * Method: getElementSizeUsingFindElements | Author: Rajesh Buddha | Date:16 Jan
	 * 2020 | Description: This method returns size of elements by using
	 * findelements | Parameters: locator, text | Return: none
	 * =============================================================================
	 *
	 * @throws InterruptedException
	 */
	public List<WebElement> getElementSizeUsingFindElements(By locator) {
		List<WebElement> lst_Elm = DriverFactory.getInstance().getMobileDriver().findElements(locator);
		ReportManager.logInfo("Successfully captured elemnt size is - " + lst_Elm.size());
		return lst_Elm;
	}

	public void verifyText(String actualText, String expectedText) {
		ReportManager.logInfo("Actual Text - " + "<b style=\"color:green;\">" + actualText + "</b>"
				+ " Matched with Expected Text - " + "<b style=\"color:green;\">" + expectedText + "</b>");
		System.out.println("Actual Text - " + actualText);
		System.out.println("Expected Text - " + expectedText);
		assertEquals(expectedText, actualText);
		System.out.println(actualText + "  Actual value is equals to " + expectedText);
	}

	public boolean isDisplayed(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean isPresent = elm.isDisplayed();
		if (isPresent) {
			ReportManager.logInfo("Successfully element displayed: " + "<b style=\"color:green;\">" + info + "</b>");
			System.out.println("Successfully element displayed: " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + "<b style=\"color:green;\">" + info + "</b>");
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public void tapElement(By locator) {
		WebElement elm = waitForVisible(locator);
		new TouchAction(DriverFactory.getInstance().getMobileDriver()).tap(tapOptions().withElement(element(elm)))
				.perform();
		ReportManager.logInfo("Successfully tapped element: ");

	}

	public void tapUsingCordinates(int x,int y) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);

		// Move to the coordinates
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
		        PointerInput.Origin.viewport(), x, y));
	}


	public boolean isEnabled(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean isenabled = elm.isEnabled();
		if (isenabled) {
			ReportManager.logInfo("Successfully element enabled: " + "<b style=\"color:green;\">" + info + "</b>");
			System.out.println("Successfully element enabled: " + info);
		} else {
			ReportManager.logInfo("element not enabled: " + "<b style=\"color:green;\">" + info + "</b>");
			System.out.println("element not enabled: " + info);

		}
		return isenabled;
	}

	public boolean isSelected(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean isChecked = elm.isSelected();
		if (isChecked) {
			ReportManager.logInfo("Successfully element selected: " + "<b style=\"color:green;\">" + info + "</b>");
			System.out.println("Successfully element selected: " + info);
		} else {
			ReportManager.logInfo("element not selected: " + "<b style=\"color:green;\">" + info + "</b>");
			System.out.println("element not selected: " + info);

		}
		return isChecked;
	}
	public void acceptAlert(String info){
		Alert alert = DriverFactory.getInstance().getMobileDriver().switchTo().alert();
		// Accept the alert (Click OK)
		String alertText = alert.getText();
		ReportManager.logInfo("Alert Text: " + "<b style=\"color:green;\">" + alertText + "</b>");
		System.out.println("Alert Text: " + alertText);
		alert.accept();
		ReportManager.logInfo("Alert is confirmed: " + "<b style=\"color:green;\">" + info + "</b>");
		System.out.println("Alert is confirmed: " + info);
	}
	public void dismissAlert(String info){
		Alert alert = DriverFactory.getInstance().getMobileDriver().switchTo().alert();
		// Accept the alert (Click OK)
		String alertText = alert.getText();
		ReportManager.logInfo("Alert Text: " + "<b style=\"color:green;\">" + alertText + "</b>");
		System.out.println("Alert Text: " + alertText);
		alert.dismiss();
		ReportManager.logInfo("Alert is dismissed: " + "<b style=\"color:green;\">" + info + "</b>");
		System.out.println("Alert is dismissed: " + info);
	}

	/* *//**
			 * This method is to swipe on element until specific text is not found
			 *
			 * @param text
			 * @return
			 */
	/*
	 * public MobileElement swipeUsingText(String text) { MobileElement element =
	 * (MobileElement) DriverFactory.getInstance().getMobileDriver()
	 * .findElement(MobileBy.
	 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
	 * ".scrollIntoView(new UiSelector().text(\"" + text + "\"))")); return element;
	 * }
	 *
	 *//**
		 * This method is to swipe until specific ID is not found
		 *
		 * @param id
		 * @return
		 */
	/*
	 * public MobileElement swipeUsingID(String id) { MobileElement element =
	 * (MobileElement) DriverFactory.getInstance().getMobileDriver()
	 * .findElement(MobileBy.
	 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
	 * ".scrollIntoView(new UiSelector().resourceIdMatches(\".*" + id + ".*\"))"));
	 * return element;
	 *
	 * }
	 *
	 * public MobileElement swipeUsingIDAndSwipeCount(String id, int count) {
	 * MobileElement element = (MobileElement)
	 * DriverFactory.getInstance().getMobileDriver().findElement( MobileBy.
	 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes("
	 * + count + ")" + ".scrollIntoView(new UiSelector().resourceIdMatches(\".*" +
	 * id + ".*\"))")); return element;
	 *
	 * }
	 *
	 *//**
		 * This method is to swipe using text and max number of count
		 *
		 * @param text
		 * @param count
		 * @return
		 */

	/*
	 * public MobileElement swipeUsingTextAndSwipeCount(String text, int count) {
	 * MobileElement element = (MobileElement)
	 * DriverFactory.getInstance().getMobileDriver().findElement( MobileBy.
	 * AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes("
	 * + count + ")" + ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	 * return element; }
	 *
	 */ /**
		 * This method is to swipe left or right
		 *
		 * @param element
		 * @param direction
		 */
	public void swipeLeftOrRight(WebElement element, String direction) {
		System.out.println("swipeElementAndroid(): dir: '" + direction + "'"); // always log your actions
		final int ANIMATION_TIME = 200; // ms
		final int PRESS_TIME = 200; // ms
		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;
		Rectangle rect = element.getRect();
		edgeBorder = 0;
		switch (direction) {
		case "LEFT": // from right to left
			pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			break;
		case "RIGHT": // from left to right
			pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + direction + "' NOT supported");
		}
		try {
			new TouchAction(DriverFactory.getInstance().getMobileDriver()).press(pointOptionStart)
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd).release()
					.perform();
		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
			return;
		}
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {
		}
	}

	public void swipeHorizontalUsingText(String resourceID, String text) {
		DriverFactory.getInstance().getMobileDriver()
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"" + resourceID
						+ "\")).setAsHorizontalList().scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));

	}

	public void swipeElementAndroid(By locator, String dir, By toLocator, int count) {
		System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions
		final int ANIMATION_TIME = 100; // ms
		final int PRESS_TIME = 100; // ms
		int edgeBorder;
		PointOption pointOptionStart, pointOptionEnd;
		WebElement el = DriverFactory.getInstance().getMobileDriver().findElement(locator);
		// init screen variables
		Rectangle rect = el.getRect();
		// sometimes it is needed to configure edgeBorders
		// you can also improve borders to have vertical/horizontal
		// or left/right/up/down border variables
		edgeBorder = 0;

		switch (dir) {

		case "DOWN": // from up to down
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			break;
		case "UP": // from down to up
			pointOptionStart = PointOption.point(rect.x + rect.width / 2, rect.y + rect.height - edgeBorder);
			pointOptionEnd = PointOption.point(rect.x + rect.width / 2, rect.y + edgeBorder);
			break;
		case "LEFT": // from right to left
			pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			break;
		case "RIGHT": // from left to right
			pointOptionStart = PointOption.point(rect.x + edgeBorder, rect.y + rect.height / 2);
			pointOptionEnd = PointOption.point(rect.x + rect.width - edgeBorder, rect.y + rect.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
		}
		// execute swipe using TouchAction
		try {

			for (int i = 0; i < count; i++) {
				boolean isToLocator = DriverFactory.getInstance().getMobileDriver().findElements(toLocator).size() > 0;
				if (!isToLocator) {
					System.out.println(i);
					new TouchAction(DriverFactory.getInstance().getMobileDriver()).press(pointOptionStart)
							// a bit more reliable when we add small wait
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME))).moveTo(pointOptionEnd)
							.release().perform();
				} else {
					break;
				}
			}

		} catch (Exception e) {
			System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
			return;
		}
		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {

		}
	}

//	public String getAttribute(By locator, String attribute, String info) {
//		WebElement elm = waitForVisible(locator);
//		String elmText = elm.getAttribute(attribute);
//		ReportManager.logInfo("" + info + "<b style=\"color:green;\"> :" + elmText + "</b>");
//		return elmText;


	public String getAttribute(By locator,String attribute) {
		WebElement elm = waitForVisible(locator);
		String elmText = elm.getAttribute(attribute);
		ReportManager.logInfo("Successfully get text - <b style=\"color:green;\">" + elmText + "</b>");
		System.out.println("Successfully get text - " + elmText);
		return elmText;
	}
	public static   void click(int x, int y, String xpath) throws InterruptedException {
		MobileActions mobileActions = new MobileActions();
		String text = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath(xpath)).getAttribute("name");
		ReportManager.logInfo("Successfully clicked on" + "<b style=\"color:green;\"> : " + text + "</b>");
		System.out.println("Successfully clicked on :-" + text);
		mobileActions.clickUsingCoordinates(x, y);
		ReportManager.logInfo("Successfully element displayed" + "<b style=\"color:green;\"> : " + text + "</b>");
		System.out.println("Successfully element displayed :-" + text);

	}
	public void closeApp()
	{
		DriverFactory.getInstance().getMobileDriver().closeApp();
		ReportManager.logInfo("Successfully Closed App - <b style=\"color:green;\">" + "</b>");
		System.out.println("Successfully Closed App" );
	}

	public void launchApp()
	{
		DriverFactory.getInstance().getMobileDriver().launchApp();
		ReportManager.logInfo("Successfully Launched App - <b style=\"color:green;\">" + "</b>");
		System.out.println("Successfully Launched App" );
	}


//	public static void waitForPageLoad() {
//		try {
//			new WebDriverWait(DriverFactory.getInstance().getMobileDriver(), DEFAULT_PAGE_LOAD_WAIT).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//		}
//		catch (Exception exception) {
//		}
//
//	}

//	public static void waitForScreenLoad()
//	{
//		try {
//			new FluentWait<AppiumDriver>(DriverFactory.getInstance().getMobileDriver()).withTimeout(DEFAULT_Screen_LOAD_WAIT).until(appiumDriver -> ((JavascriptExecutor)appiumDriver).executeScript("return document.readyState").equals("complete"));
//			ReportManager.logInfo("Successfully waited to load the screen - <b style=\"color:green;\">" + "</b>");
//			System.out.println("Successfully waited to load the screen" );
//		}
//		catch (Exception exception) {
//			System.out.println("test" );
//		}
//
//	}
//

	public void appSwitch() {
		((AndroidDriver<MobileElement>) DriverFactory.getInstance().getMobileDriver()).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}
	public void backButton() {


		((AndroidDriver<MobileElement>) DriverFactory.getInstance().getMobileDriver()).navigate().back();
				//.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));


	}

	public void enterKeyboard(AndroidKey testKey) {
		((AndroidDriver<MobileElement>) DriverFactory.getInstance().getMobileDriver()).pressKey(new KeyEvent(testKey));
				//.pressKey(new KeyEvent(testKey));;

	}





}
