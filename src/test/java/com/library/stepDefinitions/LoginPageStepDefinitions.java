package com.library.stepDefinitions;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoginPageStepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.site"));

    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {

        loginPage.emailInputBox.sendKeys("librarian1@library");

    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {

        loginPage.passwordInputBox.sendKeys("qU9mrvur");
        loginPage.signInButton.click();


    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {


    }

    @When("user enters student username")
    public void user_enters_student_username() {
        loginPage.emailInputBox.sendKeys("student1@library");


    }

    @When("user enters student password")
    public void user_enters_student_password() {
        loginPage.passwordInputBox.sendKeys("d5fv9BtX");
        loginPage.signInButton.click();


    }

    @When("user enters librarian username {string}")
    public void user_enters_librarian_username(String string) {

        loginPage.emailInputBox.sendKeys(string);

    }

    @When("user enters librarian password {string}")
    public void user_enters_librarian_password(String string) {

        loginPage.passwordInputBox.sendKeys(string);

    }

    @When("user enters student username {string}")
    public void user_enters_student_username(String string) {


        loginPage.emailInputBox.sendKeys(string);
    }

    @When("user enters student password {string}")
    public void user_enters_student_password(String string) {

        loginPage.passwordInputBox.sendKeys(string);


    }


    //TASK4


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.site"));

    }
    @When("I login using {string} and {string}")
    public void i_login_using_and(String string, String string2) {
        loginPage.emailInputBox.sendKeys(string);
        loginPage.passwordInputBox.sendKeys(string2);
        loginPage.signInButton.click();

    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        Assert.assertTrue(loginPage.userNumbers.isDisplayed());

    }
    @Then("there should be {int} {string}")
    public void there_should_be(Integer int1, String string) {
        BrowserUtils.sleep(2);
        String user = loginPage.userNumbers.getText();
        String userText = loginPage.usersText.getText();
        Assert.assertTrue(Integer.parseInt(user) == int1);
        Assert.assertTrue(string.equalsIgnoreCase(userText));

    }

    //TASK5

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {

        user_enters_librarian_username();
        user_enters_librarian_password();

    }
    @Given("I click on {string} link")
    public void i_click_on_link(String string) {

        BrowserUtils.clickLink(string);

    }
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> columnList) {

        List<WebElement> columnNames = dashBoardPage.columnNames;
        List<String> columnName = new ArrayList<>();

        for (WebElement each : columnNames) {
            columnName.add(each.getText());
        }

        for (String each : columnList) {
            Assert.assertTrue(columnList.containsAll(columnName));
        }

    }


    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String name) {

        wait.until(ExpectedConditions.visibilityOf(dashBoardPage.userNameCheck));
        String a = dashBoardPage.userNameCheck.getText();
        Assert.assertTrue(a.contains(name));

    }
}
