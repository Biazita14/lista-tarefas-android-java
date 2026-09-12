package com.example.myapplication.tests;

import com.example.myapplication.pages.TaskDashboardPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskDashboardTest {
    private WebDriver driver;
    private TaskDashboardPage dashboardPage;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");
        dashboardPage = new TaskDashboardPage(driver);

        // Pausa de 2 segundos após abrir a página
        Thread.sleep(2000);
    }

    @Test
    public void deveCriarNovaTarefaComSucesso() throws InterruptedException {
        String usuario = "tomsmith";

        // Preenche os dados e aguarda 2 segundos para você ver o texto digitado
        dashboardPage.preencherNomeTarefa(usuario);
        Thread.sleep(2000);

        // Clica no botão e aguarda 2 segundos após o clique
        dashboardPage.clicarAdicionar();
        Thread.sleep(2000);

        String mensagem = dashboardPage.obterTextoUltimaTarefa();
        Assert.assertTrue(mensagem.contains("You logged into a secure area!"));
    }

    @After
    public void tearDown() {
        // O quit é o que fecha a pag automaticamente
         if (driver != null) {
             driver.quit();
         }
    }
}