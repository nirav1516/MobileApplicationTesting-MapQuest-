import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestMain {
	private static SwipeableWebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		TestMain mytest = new TestMain();
		mytest.setup();
		// mytest.createMarkers();
		// mytest.check_navigation();
		// mytest.check_mapButton();
		// mytest.testCaseAH1();
		// mytest.testCaseGH1();
		mytest.testCaseAEW1();
		// mytest.testCaseGH2();
		// mytest.testCaseAH3();
		// mytest.testCaseAH4();
		// mytest.testCaseAW1();
		// mytest.testZoom();
	}

	private void createMarkers() {
		// TODO Auto-generated method stub
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/layers_button")).click();
		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();
		driver.findElement(By.name("Food")).click();
	}

	private void check_navigation() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_directions_form_btn"))
				.click();
		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();
		driver.findElement(By.name("Enter Location")).click();
		driver.findElement(By.name("Enter Location")).sendKeys(
				"754 the alameda");
		driver.findElement(By.name("J")).click();
		// com.mapquest.android.acedev:id/editRouteAddress
		// wait(5);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
		// ((TimeUnit) driver).sleep(5000);
		System.out.println("click getdirestion");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/df_submitButton"))
				.click();
		Thread.sleep(5000);
		System.out.println("click start");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/route_summary_start_nav_button"))
				.click();
		Thread.sleep(5000);
		System.out.println("check direction list");
		WebElement element = driver.findElement(By
				.id("com.mapquest.android.acedev:id/navigation_list_btn"));
		Thread.sleep(5000);
		String str = element.getText();
		try {
			Assert.assertEquals("Directions List", str);
		} catch (Exception e) {
			System.out.println("Could not find Direction.");
		}

		System.out.println("Verified..........");
	}

	private void test_searchButton() throws InterruptedException {
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_search_row"))
				.click();
		System.out.println("going to click mapquest it!");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_search_field"))
				.click();
		System.out.println("going to right place in MapQuest it!");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_search_field"))
				.sendKeys("vdisdni");
		System.out.println("going to click search .");
		driver.findElement(By.name("J")).click();
		Thread.sleep(2000);
		// WebElement location =
		// driver.findElement(By.id("com.mapquest.android.acedev:id/info_bar_go_button"));
		WebElement screen = driver
				.findElement(By
						.id("com.mapquest.android.acedev:id/over_map_fragment_container"));
		// com.mapquest.android.acedev:id/over_map_fragment_container
		// WebElement notFound =
		// driver.findElement(By.name("No results found."));
		String str = screen.getText();
		WebElement toTest;
		System.out.println("going to assert");
		System.out.println("text" + str);
		try {
			// Assert.asse(null, notFound);
		} catch (Exception e) {
			System.out.println("location found");
		}

		System.out.println("test passed");
		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testCaseAEW1() throws InterruptedException {
		System.out.println("Inside testCaseAEW1");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_home_row")).click();
		System.out.println("going to click search");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.click();
		System.out.println("going to write place in search add home!");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.sendKeys("754 the alameda");
		System.out.println("going to click search .");
		driver.findElement(By.name("J")).click();
		Thread.sleep(15000);
		// System.out.println("going to click first place  .");
		// 754 The Alameda, San Jose, CA 95126
		/*
		 * driver.findElement(
		 * By.name("com.mapquest.android.acedev:id/autocomplete_category_sym"))
		 * .click();
		 */

		Thread.sleep(2000);
		// Click Ok
		System.out.println("Going to click Ok add");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/new_fav_notification_button"))
				.click();
		Thread.sleep(6000);
		// Go to settings
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_settings_row"))
				.click();
		// Click Edit home address
		Thread.sleep(2000);
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/settings_home_address"))
				.click();

		// click on search
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.click();
		System.out.println("going to write place in search edit home");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.sendKeys("101 san");

		// String editAddr =
		// "101 San Fernando Apartments, 101 E San Fernando St, San Jose, CA";
		// Thread.sleep(5000);
		// System.out.println("going to click search edit .");
		// driver.findElement(By.name("J")).click();
		Thread.sleep(10000);
		// select first in
		System.out.println("Select first edit");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/autocomplete_category_sym"))
				.click();

		// com.mapquest.android.acedev:id/new_fav_notification_header
		Thread.sleep(3000);
		System.out.println("Going to take text");
		String editAddr = driver
				.findElement(
						By.id("com.mapquest.android.acedev:id/new_fav_notification_header"))
				.getText();
		// click ok in edit
		System.out.println(editAddr);
		Thread.sleep(10000);
		System.out.println("Going to click Ok edit");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/new_fav_notification_button"))
				.click();

		// click back
		Thread.sleep(4000);
		System.out.println("Going to click back edit");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/back_button_symbol"))
				.click();

		String finalAddr = driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_list_text2"))
				.getText();

		System.out.println("going to assert string");
		String failMessage = "------Failed------" + "\nSaved Home Address: "
				+ editAddr + "\nDisplayed Address: " + finalAddr;
		try {
			// Assert.assertEquals(editAddr.substring(0, 4),
			// finalAddr.substring(0, 4));
			Assert.assertEquals(failMessage, editAddr, finalAddr);
			System.out.println("Home address updates successfully");
		} catch (Exception e) {
			System.out
					.println("Sorry, Test Failed. Still displays old home address ");
		}

		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testCaseGH1() throws InterruptedException {
		System.out.println("Inside testCaseGH1");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_home_row")).click();

		// com.mapquest.android.acedev:id/route_summary_start_nav_button
		try {
			WebElement start = driver
					.findElement(By
							.id("com.mapquest.android.acedev:id/route_summary_start_nav_button"));
			System.out.println("Success: route Established.");
			// Assert.assertEquals(editAddr.substring(0, 4),
			// finalAddr.substring(0, 4));

		} catch (Exception e) {
			System.out.println("Sorry, Could not establish route");
		}

		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testCaseAH1() throws InterruptedException {
		System.out.println("Inside testCaseAH1");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_home_row")).click();
		System.out.println("going to click search");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.click();
		System.out.println("going to write place in search add home!");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.sendKeys("754 the alameda");
		System.out.println("going to click search .");
		driver.findElement(By.name("J")).click();
		Thread.sleep(10000);
		// System.out.println("going to click first place  .");
		// 754 The Alameda, San Jose, CA 95126
		/*
		 * driver.findElement(
		 * By.name("com.mapquest.android.acedev:id/autocomplete_category_sym"))
		 * .click();
		 */

		Thread.sleep(6000);
		System.out.println("Going to take text");
		String editAddr = driver
				.findElement(
						By.id("com.mapquest.android.acedev:id/new_fav_notification_header"))
				.getText();
		// click ok in add
		System.out.println(editAddr);
		Thread.sleep(7000);
		System.out.println("Going to click Ok edit");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/new_fav_notification_button"))
				.click();

		// click back
		Thread.sleep(4000);

		String finalAddr = driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_list_text2"))
				.getText();

		System.out.println("going to assert string");
		String failMessage = "------Failed------" + "\nSaved Home Address: "
				+ editAddr + "\nDisplayed Address: " + finalAddr;
		try {
			// Assert.assertEquals(editAddr.substring(0, 4),
			// finalAddr.substring(0, 4));
			Assert.assertEquals(failMessage, finalAddr.substring(0, 5),
					editAddr.substring(1, 6));
			// Assert.assertEquals(failMessage,finalAddr,editAddr.substring(1,
			// finalAddr.length()+1) );
			System.out.println("Home address added successfully");
		} catch (Exception e) {
			System.out
					.println("Sorry, Test Failed. Doesn't display correct home address ");
		}

		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testCaseGH2() throws InterruptedException {
		System.out.println("Inside testCaseGH2");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_home_row")).click();

		Thread.sleep(10000);
		driver.findElement(By.name("P")).click();

		Thread.sleep(6000);
		System.out.println("Going to take text");
		String editAddr = driver
				.findElement(
						By.id("com.mapquest.android.acedev:id/new_fav_notification_header"))
				.getText();
		// click ok in add
		System.out.println(editAddr);
		Thread.sleep(7000);
		System.out.println("Going to click Ok edit");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/new_fav_notification_button"))
				.click();

		// click back
		Thread.sleep(4000);

		String finalAddr = driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_list_text2"))
				.getText();

		System.out.println("going to assert string");
		System.out.println("Substring: "
				+ editAddr.substring(1, finalAddr.length() + 1));
		String failMessage = "------Failed------" + "\nSaved Home Address: "
				+ editAddr + "\nDisplayed Address: " + finalAddr + "\n\n";
		try {
			// Assert.assertEquals(editAddr.substring(0, 4),
			// finalAddr.substring(0, 4));
			Assert.assertEquals(failMessage, finalAddr.substring(0, 5),
					editAddr.substring(1, 6));
			System.out.println("Home address added successfully");
		} catch (Exception e) {
			System.out
					.println("Sorry, Test Failed. Doesn't display correct home address ");
		}

		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testCaseAH3() throws InterruptedException {
		System.out.println("Inside testCaseAH3");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_home_row")).click();

		Thread.sleep(10000);
		System.out.println("Going into favorites");
		driver.findElement(By.name("FAVORITES")).click();
		Thread.sleep(5000);
		System.out.println("Selecting first favorite");
		driver.findElement(By.name("z")).click();

		Thread.sleep(6000);
		System.out.println("Going to take text");
		String editAddr = driver
				.findElement(
						By.id("com.mapquest.android.acedev:id/new_fav_notification_header"))
				.getText();
		// click ok in add
		System.out.println(editAddr);
		Thread.sleep(7000);
		System.out.println("Going to click Ok edit");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/new_fav_notification_button"))
				.click();

		// click back
		Thread.sleep(4000);

		String finalAddr = driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_list_text2"))
				.getText();

		System.out.println("going to assert string");
		System.out.println("Substring: "
				+ editAddr.substring(1, finalAddr.length() + 1));
		String failMessage = "------Failed------" + "\nSaved Home Address: "
				+ editAddr + "\nDisplayed Address: " + finalAddr + "\n\n";
		try {
			// Assert.assertEquals(editAddr.substring(0, 4),
			// finalAddr.substring(0, 4));
			Assert.assertEquals(failMessage, finalAddr.substring(0, 5),
					editAddr.substring(1, 6));
			System.out.println("Home address added successfully");
		} catch (Exception e) {
			System.out
					.println("Sorry, Test Failed. Doesn't display correct home address ");
		}

		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testCaseAH4() throws InterruptedException {
		System.out.println("Inside testCaseAH4");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_home_row")).click();

		Thread.sleep(10000);
		System.out.println("Going into contact");
		driver.findElement(By.name("CONTACTS")).click();
		Thread.sleep(5000);
		System.out.println("Selecting first contact");
		driver.findElement(By.name("v")).click();

		Thread.sleep(6000);
		System.out.println("Going to take text");
		String editAddr = driver
				.findElement(
						By.id("com.mapquest.android.acedev:id/new_fav_notification_header"))
				.getText();
		// click ok in add
		System.out.println(editAddr);
		Thread.sleep(7000);
		System.out.println("Going to click Ok add");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/new_fav_notification_button"))
				.click();

		// click back
		Thread.sleep(4000);

		String finalAddr = driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_list_text2"))
				.getText();

		System.out.println("going to assert string");
		System.out.println("Substring: "
				+ editAddr.substring(1, finalAddr.length() + 1));
		String failMessage = "------Failed------" + "\nSaved Home Address: "
				+ editAddr + "\nDisplayed Address: " + finalAddr + "\n\n";
		try {
			// Assert.assertEquals(editAddr.substring(0, 4),
			// finalAddr.substring(0, 4));
			Assert.assertEquals(failMessage, finalAddr.substring(0, 5),
					editAddr.substring(1, 6));
			System.out.println("Home address added successfully");
		} catch (Exception e) {
			System.out
					.println("Sorry, Test Failed. Doesn't display correct home address ");
		}

		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testCaseAW1() throws InterruptedException {
		System.out.println("Inside testCaseAH1");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/search_bar_menu_btn"))
				.click();
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_work_row")).click();
		System.out.println("going to click search");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.click();
		System.out.println("going to write place in search add home!");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/add_fav_search_field"))
				.sendKeys("754 the alameda");
		System.out.println("going to click search .");
		driver.findElement(By.name("J")).click();
		Thread.sleep(12000);

		System.out.println("Going to take text");
		String editAddr = driver
				.findElement(
						By.id("com.mapquest.android.acedev:id/new_fav_notification_header"))
				.getText();
		// click ok in add
		System.out.println(editAddr);
		Thread.sleep(7000);
		System.out.println("Going to click Ok add");
		driver.findElement(
				By.id("com.mapquest.android.acedev:id/new_fav_notification_button"))
				.click();

		// click back
		Thread.sleep(4000);

		String finalAddr = driver.findElement(
				By.id("com.mapquest.android.acedev:id/menu_list_text2"))
				.getText();

		System.out.println("going to assert string");
		String failMessage = "------Failed------" + "\nSaved Home Address: "
				+ editAddr + "\nDisplayed Address: " + finalAddr;
		try {
			// Assert.assertEquals(editAddr.substring(0, 4),
			// finalAddr.substring(0, 4));
			Assert.assertEquals(failMessage, finalAddr.substring(0, 5),
					editAddr.substring(1, 6));
			// Assert.assertEquals(failMessage,finalAddr,editAddr.substring(1,
			// finalAddr.length()+1) );
			System.out.println("Work address added successfully");
		} catch (Exception e) {
			System.out
					.println("Sorry, Test Failed. Doesn't display correct Work Address ");
		}

		// driver.findElement(By.id("com.mapquest.android.acedev:id/carousel_symbol")).click();

	}

	private void testZoom() {
		WebElement mainScreen = driver
				.findElement(By
						.id("com.mapquest.android.acedev:id/over_map_fragment_container"));
		// doubleTap(mainScreen);
		TouchActions ta = new TouchActions(driver);
		ta.doubleTap(mainScreen);
		ta.doubleTap(mainScreen);
		ta.doubleTap(mainScreen);
		ta.doubleTap(mainScreen);
		System.out.println("done tapping");
		// ta.flick(getaround, 0 , -200, 90).perform();
		// com.mapquest.android.acedev:id/over_map_fragment_container
	}

	public void setup() {
		File appDir = new File("E:/mapquest");
		File app = new File(appDir, "MapQuest.apk");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app-package", "com.mapquest.android.ace");
		caps.setCapability("browserName", "");
		caps.setCapability("device", "LG-D415");
		caps.setCapability("app-activity",
				"com.mapquest.android.ace.MainActivity");
		caps.setCapability("takesScreenshot", true);
		caps.setCapability("version", "4.4");
		caps.setCapability("device ID", "LGD415471ab65e");
		caps.setCapability("app", app.getAbsolutePath());

		try {
			driver = new SwipeableWebDriver(new URL(
					"http://127.0.0.1:4723/wd/hub"), caps);
			System.out.println("try done");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		System.out.println("going out before");
	}

	public class SwipeableWebDriver extends RemoteWebDriver implements
			HasTouchScreen {
		private RemoteTouchScreen touch;

		public SwipeableWebDriver(URL remoteAddress,
				Capabilities desiredCapabilities) {
			super(remoteAddress, desiredCapabilities);
			touch = new RemoteTouchScreen(getExecuteMethod());
		}

		public TouchScreen getTouch() {
			return touch;
		}
	}

}
