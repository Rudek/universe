import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:7000/')

WebUI.click(findTestObject('Object Repository/Page_Home  Universe/a_Sign up'))

WebUI.setText(findTestObject('Object Repository/Page_Sign Up  Universe/input_First name_first-name'), 'Maxim')

WebUI.setText(findTestObject('Object Repository/Page_Sign Up  Universe/input_Last name_last-name'), 'Rudenko')

WebUI.setText(findTestObject('Object Repository/Page_Sign Up  Universe/input_Email_email'), 'maxim.s.rudenko@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign Up  Universe/input_Password_password'), 'lLoX3JdcF1ayuKW5a7W/Ow==')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign Up  Universe/input_Confirm password_confirm-password'),
        'lLoX3JdcF1ayuKW5a7W/Ow==')

WebUI.click(findTestObject('Object Repository/Page_Sign Up  Universe/button_Sign up'))

WebUI.click(findTestObject('Object Repository/Page_Home  Universe/div_You have successfully signed up. Welcom_6a025a'))

WebUI.click(findTestObject('Object Repository/Page_Home  Universe/button_OK'))

WebUI.closeBrowser()

