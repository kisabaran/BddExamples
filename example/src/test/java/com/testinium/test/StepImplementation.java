package com.testinium.test;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;


public class StepImplementation extends BaseTes {
    @Step({"batuhan","hello batu"})
    public void xxxx (){
        sleep(100);
        driver.findElement(By.id("productSearch")).sendKeys("batuhan");
        sleep(1000);
}

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    @Step("testinium")
    public void testinium(){
        sleep(5400);
    }

}
