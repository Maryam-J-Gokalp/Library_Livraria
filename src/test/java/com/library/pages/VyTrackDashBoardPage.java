package com.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VyTrackDashBoardPage extends VyTrackLoginPage {

    @FindBy(css = "#user-menu>a")
    public WebElement userVisibility;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    public WebElement loaderMask;


    public void logout(){
        userVisibility.click();
        logoutLink.click();
    }
}
