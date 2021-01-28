package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduca el movil que desea buscar: ");
        String buscarMovil = sc.nextLine();
        Chrome();
        try {
            WebElement ventanaCookies =
                    driver.findElement(By.xpath("//*[@id=\"familia-secundaria\"]/div[5]/div/div/div[2]/button"));
            if (ventanaCookies != null){
                System.out.println("Detectado caja de cookies");
                ventanaCookies.click();
            }
        }catch (Exception e){
            System.out.println("No se encuentra la caja de Cookies");
        }

        WebElement cajaBusqueda =
                driver.findElement(By.name("query"));
        cajaBusqueda.sendKeys(buscarMovil);
        cajaBusqueda.sendKeys(Keys.ENTER);
        //cajaBusqueda.submit();

        try {
            List<WebElement> listElementos = driver.findElements(By.xpath("//*[@class=\"c-product-card__content\"]"));
            System.out.println(listElementos.size());
        try {
            for (int i = 1; i < 4; i++) {
               String Price = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]/div["+i+"]/article/div/div/div[2]/div/span")).getText();
               String Name = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]/div["+i+"]/article/div/div[2]/header/h3/a")).getText();
               System.out.println(i + " " + Name + " " + Price);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No te funciona payaso");
        }
        }catch (Exception o){
            System.out.println("No funciona dfbdjjfsdmfljbdsfkodsnfjdsjfk");
            System.out.println("asidsajdn");
        }
    }
    private static ChromeDriver driver = null;
    private static void Chrome() {
        String exePath = "C:\\Users\\Antonio\\Desktop\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get("https://www.pccomponentes.com/smartphone-moviles");
        driver.manage().window().maximize();
    }

}
