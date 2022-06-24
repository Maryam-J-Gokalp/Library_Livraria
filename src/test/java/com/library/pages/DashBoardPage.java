package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashBoardPage extends LoginPage{

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersLink;


    @FindBy(xpath = "//span[.='Books']")
    public WebElement booksLink;

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboardLink;

    @FindBy(xpath = "//thead//th")
    public List<WebElement> columnNames;


    @FindBy(xpath = "//a[@id='navbarDropdown']//span")
    public WebElement userNameCheck;

}
