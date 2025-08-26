# Koo Mobile Automation Framework
> Using Appium to Automate UI Testing of Android and iOS Koo Application with Java
> Basically you need to have appium installed along with appium-doctor


## CLI - Run specific test suite from CLI
> mvn clean test -Dsuite="YOUR_SUITE_FILE.xml"

> mvn clean test -Dsuite="Android_Suite_SingleDevice.xml"

 

## Use browser stack from CLI 
> mvn clean test -Dsuite="YOUR_BS_SUITE_FILE.xml" -Dbrowserstack = true

> _Note_: If you are not passing CLI option -Dbrowserstack then it will pick by default from the config > browserstack


## Running the tests on local device :
 
> To run your tests on local simply you need to execute the following xml file
Android_Suite_SingleDevice.xml

> Running the tests on browser stack for single device :

> _Update:_ "browserstack" parameter value in config.properties and set as "Yes". 

> To run your tests on browser stack simply you need to execute the following xml file
Android_Suite_SingleDevice_BS.xml

## Running the tests on browser stack for multiple device :

> Update "browserstack" parameter value in config.properties and set as "Yes".
To run your tests on browser stack simply you need to execute the following xml file
Android_Suite_MultipleDevices_BS.xml

## Tools Used :

* Selenium WebDriver : 3.14.0
* TestNG : 7.4.0
* Maven : 3.5.1
* Appium
* Apache POI
* Extent Report


## Data Driven Framework : 

> Used Fillo API with data provider to fetch the data for different languages from excel file that is under resources > Files > TestData.xlsx

## Locators :

> Added locators in .json file under resources > Locators directory

## Page Object Model : 

> Added pages under src > test > java > com.framework > android > screens package
> 
> Added tests under src > test > java > com.framework > android > testcases package
> 
> Added common classes and helper classes under src > test > java > com.framework > android > utils package
> 
> Run from maven : 
> mvn clean test -DsuiteXmlFile=Android_Suite_MultipleDevices_BS.xml
> mvn clean test -DsuiteXmlFile=Android_Suite_SingleDevices_BS.xml
> mvn clean test -DsuiteXmlFile=Android_Suite_SingleDevice.xml // For real device use this command
