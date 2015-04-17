package com.epam.tests.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class SearchPage extends WebDriverPage {

    WebDriverWait wait;

    public SearchPage(WebDriverProvider driverProvider) {
        super(driverProvider);
        wait = new WebDriverWait(driverProvider.get(), 30);
        PageFactory.initElements(driverProvider.get(), this);
    }

    public void open() {
        get("http://www.yahoo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-submit")));

    }

    public void typeSearchParameters(String searchParameters) {
        findElement(By.id("p_13838465-p")).sendKeys(searchParameters);
    }

    public void clickSearchButton() {
        findElement(By.id("search-submit")).click();
    }

    
    public void clickFirstLink() {
    
    	
    	
        findElement(By.xpath("//div[@id='web']/ol[1]//h3[@class='title']/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='weather']/div[3]/div[1]/h1")));
        for (String winHandle : getWindowHandles()) {
           switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }  

    } 
    
    public boolean verifySearchResults() {
        try {
            findElement(By
                .xpath(".//div[@class='compPagination']/span")).isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }
    
    public boolean  verifySearchAutomationResults() {
        try {
        	  findElement(By.xpath(".//*[@id='logo']")).isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }
   
    
    public boolean verifySearchClickResults() {
    	 try { 		
    	  
           findElement(By
              .xpath(".//*[@id='page']/div[3]/div[1]/a/img")).isDisplayed();
          return true;
       } catch (NoSuchElementException ex) {
           ex.getMessage();
          return false;
      }
  }
    


    public boolean verifyEmptySearchMessage() {
        try {
            findElement(By.xpath(".//div[@class='compText mb-15 fz-m fc-4th']/p")).isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }
}
