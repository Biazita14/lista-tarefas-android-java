package com.example.myapplication.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskDashboardPage {
    private WebDriver driver;

    // Elementos do formulário de login leve
    private By inputUsername = By.id("username");
    private By inputPassword = By.id("password");
    private By buttonSubmit = By.cssSelector("button[type='submit']");
    private By flashMessage = By.id("flash");

    public TaskDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherNomeTarefa(String nome) {
        driver.findElement(inputUsername).sendKeys(nome);
        driver.findElement(inputPassword).sendKeys("SuperSecretPassword!");
    }

    public void clicarAdicionar() {
        driver.findElement(buttonSubmit).click();
    }

    public String obterTextoUltimaTarefa() {
        return driver.findElement(flashMessage).getText();
    }
}
