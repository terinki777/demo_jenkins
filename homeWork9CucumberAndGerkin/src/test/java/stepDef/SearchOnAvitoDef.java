package stepDef;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchOnAvitoDef extends Site {

    @ParameterType(".*")
    public SortPrice sortP(String s) {
        return SortPrice.valueOf(s);
    }

    @ParameterType(".*")
    public Category category(String c) {
        return Category.valueOf(c);
    }

    @Пусть("открыт ресурс авито")
    public static void openResource() {
        setUp();
        driver.get("https://www.avito.ru/");
        Allure.addAttachment("Открыт ресурс авито ", "");
        captureScreenshot(driver);
    }

    @И("в выпадающем списке категорий выбрана {category}")
    public void selectCategory(Category c) {
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText(c.value);
        Allure.addAttachment("В выпадающем списке категорий выбрана ", c.value);
        captureScreenshot(driver);
    }

    @И("в поле поиска введено значение {string}")
    public static void valueEnteredInSearchField(String value) {
        driver.findElement(By.xpath("//div/label/input[@data-marker='search-form/suggest']"))
                .sendKeys(value);
        Allure.addAttachment("В поле поиска введено значение ", value);
        captureScreenshot(driver);
    }

    @И("активирован чекбокс только с фотографией")
    public static void activatedCheckBoxWithPhotoOnly() {
        driver.findElement(By.cssSelector("#app>div")).click();
        driver.findElement(By.xpath("//input[@name='withImagesOnly']/parent::node()")).click();
        Allure.addAttachment("Активирован чекбокс только с фотографией ", "");
        captureScreenshot(driver);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void dropdownListClick() {
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']/div"))
                .click();
        Allure.addAttachment("Кликнуть по выпадающему списку региона ", "");
        captureScreenshot(driver);
    }

    @Тогда("в поле регион введено значение {string}")
    public static void enteredValueInRegion(String region) {
        driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']"))
                .sendKeys(region);
        driver.findElement(By.xpath("//strong")).click();
        Allure.addAttachment("В поле регион введено значение ", region);
        captureScreenshot(driver);
    }

    @И("нажата кнопка показать объявления")
    public static void showAdsClick() {
        driver.findElement(By.xpath("//div/button[@data-marker='popup-location/save-button']"))
                .click();
        Allure.addAttachment("Нажата кнопка показать объявления ", "");
        captureScreenshot(driver);
    }

    @Тогда("открылась страница результата по запросу {string}")
    public static void openPageOnRequest(String value) {
        if (driver.findElement(By.xpath("//div/label/input[@data-marker=" +
                "'search-form/suggest'][@value]")).getText() == value)
            driver.findElement(By.xpath("//div[@class]/button[@data-marker='search-filters/submit-button']")).click();
        Allure.addAttachment("Открылась страница результата по запросу ", value);
        captureScreenshot(driver);
    }

    @И("в выпадающем списке сортировка значения {sortP}")
    public static void sortInDropdownsList(SortPrice s) {
        Select selectSort = new Select(driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]")));
        selectSort.selectByVisibleText(s.value);
        Allure.addAttachment("Открылась страница результата по запросу ", s.value);
        captureScreenshot(driver);
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public static void printedToTheConsole(int num) {
        List<WebElement> title = driver.findElements(By.xpath("//div[starts-with" +
                "(@class,'iva-item-titleStep')]"));
        List<WebElement> price = driver.findElements(By.xpath("//div[starts-with" +
                "(@class,'iva-item-priceStep')]"));
        Allure.addAttachment("В консоль выведено значение названия и цены " + num + " первых товаров", "");
        for (int i = 0; i < num; ++i) {
            String attachment = "Title: " + title.get(i).getText() + "\nPrice: " + price.get(i).getText();
            System.out.println("Position " + (i + 1) + ": \n" + attachment);
            Allure.addAttachment("Position " + (i + 1) + ": ", attachment);
        }
        params = driver.findElement(By.xpath("//div[@class]/select[option" +
                "[contains(text(),'Дороже')]]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", params);

        captureScreenshot(driver);
        teardown();
    }

}
