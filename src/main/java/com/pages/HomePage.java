package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By topNavigationBarItemsLocator = By.xpath("//a[@class='level-top ui-corner-all']");
    private By footerLinkLocator = By.xpath("//div[@class='footer content']//a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getCountOfElements(String whichPartOfPage) {
        int count = 0;
        switch (whichPartOfPage) {
            case "top navigation bar":
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(topNavigationBarItemsLocator));
                count = driver.findElements(topNavigationBarItemsLocator).size();
                break;
            case "footer":
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerLinkLocator));
                count = driver.findElements(footerLinkLocator).size();
                break;
            default:
                System.out.println("Provide a correct part of the page");
        }
        return count;
    }

    public List<String> getListofGivenElements(String whichPartOfThePage) {
        List<String> elementsListValue = new ArrayList<>();
        List<WebElement> listElements = null;

        switch (whichPartOfThePage) {
            case "top navigation bar":
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(topNavigationBarItemsLocator));
                listElements = driver.findElements(topNavigationBarItemsLocator);
                break;
            case "footer":
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footerLinkLocator));
                listElements = driver.findElements(footerLinkLocator);
                break;
            default:
                System.out.println("Provide a correct part of the page");
        }

        if (listElements != null && !listElements.isEmpty()) {
            for (WebElement e : listElements) {
                elementsListValue.add(e.getText().trim());
            }
        } else {
            System.out.println("No elements found for: " + whichPartOfThePage);
        }

        return elementsListValue;
    }
}
