package com.framework.goodhealthgateway.android.Actions;


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
import java.util.List;

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
		ReportManager.logInfo("Successfully clicked on " + " <b style=\"color:green;\"> " + info + "</b>"+"button");
		System.out.println("Successfully clicked on - " + info);

		// ReportManager.logScreenshotInfo();

	}



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
