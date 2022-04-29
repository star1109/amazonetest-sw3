package testsuite;

import browsertesting.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AmazoneSearch extends Utility
{
        String baseUrl = "https://www.amazon.co.uk/";

        @Before
        public void SetUp() {
            openBrowser(baseUrl);
        }

        @Test
        public void verifyTheProductsDisplayed() {
            clickOnElement(By.id("sp-cc-accept"));//accept cookies
            sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");//send text to search bar
            clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));//click on search button
            //click on checkbox against 'Dell'
            clickOnElement(By.xpath("//*[@id=\"p_89/Dell\"]/span/a/div/label/i"));

            WebElement productDell=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            int countProducts = products.size();
            List<String> actualListName = new ArrayList<>();
            for (WebElement element : products) {
                actualListName.add(element.getText());
            }
            //verify products count
            if (productDell.isDisplayed()){
                Assert.assertEquals("Check number of products : ",countProducts,30);}
            //print the products list
            System.out.println("Prodcuts Name:"+ actualListName);

        }
        @After
        public void tearDown(){
            closeBrowser();
        }
}
