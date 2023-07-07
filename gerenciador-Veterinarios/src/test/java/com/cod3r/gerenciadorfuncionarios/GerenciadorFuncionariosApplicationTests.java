package com.cod3r.gerenciadorfuncionarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = GerenciadorFuncionariosApplicationTests.class)
class GerenciadorFuncionariosApplicationTests {

	@Test
	void find() {

		//Precisa dessas três linhas para criar o Driver e abrir o Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/find");

		WebElement nome = driver.findElement(By.name("nome"));
		nome.sendKeys("Erica Queiroz Pinto");

		WebElement btn = driver.findElement(By.className("btn-dark"));
		btn.click();

		WebElement table = driver.findElement(By.tagName("td"));
		assertEquals("Erica Queiroz Pinto", table.getText());


	}

	@Test
	void delete() {

		//Precisa dessas três linhas para criar o Driver e abrir o Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/home");

		WebElement nome = driver.findElement(By.tagName("td"));

		if(nome.getText() == "Erica Queiroz Pinto"){
			WebElement btn = driver.findElement(By.className("btn-danger"));
			btn.click();
		}

	}

	@Test
	void add() {

		//Precisa dessas três linhas para criar o Driver e abrir o Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/home");

		WebElement btnAdd = driver.findElement(By.cssSelector(".btn-dark"));
		btnAdd.click();

		driver.findElement(By.id("nome")).sendKeys("Hugo Ribeiro Alves");
		driver.findElement(By.id("inputEmail")).sendKeys("hugo@email.com");
		driver.findElement(By.id("inputEspecialidade")).sendKeys("cachorro");
		driver.findElement(By.id("inputSalario")).sendKeys("100000");

		WebElement btn = driver.findElement(By.tagName("button"));
		btn.click();





	}

}
