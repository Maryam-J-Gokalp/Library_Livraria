package com.library.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BrowserUtils {
    /**
     * This method accept seconds and wait end of the duration
     * @param seconds
     */

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }

    public static void clickLink(String linkName){

        try{
            WebElement clickElement = Driver.getDriver().findElement(By.xpath("//span[.='" + linkName + "']"));
            clickElement.click();
        }catch (NoSuchElementException e){
            System.out.println("Element can not found with method - Check clickLink() method");
        }
    }

}
