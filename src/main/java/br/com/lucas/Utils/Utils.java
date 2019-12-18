package br.com.lucas.Utils;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.lucas.driverFactory.DriverFactory;

public class Utils extends DriverFactory {

	WebElement elemento;
	
	
	public static int getQuantidadeElementos(By campo) {
		DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(campo));
		List<WebElement>elementos = DriverFactory.getInstance().findElements(campo);
		return elementos.size();		
	}
	
	public String getName(By campo) {
		DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(campo));
		elemento = DriverFactory.getInstance().findElement(campo);
		return elemento.getText();
	}
	
	public String getUrl() {
		return DriverFactory.getInstance().getCurrentUrl();
	}
	
	public Set<String> getJanelas() {
	  	return DriverFactory.getInstance().getWindowHandles();
	}
	
	public void trocaParaAba(String aba) {
		DriverFactory.getInstance().switchTo().window(aba);
	}

	public void limpaEInsereTextoWait(String texto, By campo) {
		DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(campo));
		elemento = DriverFactory.getInstance().findElement(campo);
		elemento.clear();
		elemento.sendKeys(texto);
	}

	public void clicaWait(By campo) {
		DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(campo));
		elemento = DriverFactory.getInstance().findElement(campo);
		elemento.click();
	}

	public void validoMensagemWait(String mensagem) {
		try {
			By byMensagem = By.xpath("//*[contains(text(),'" + mensagem + "')]");
			DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(byMensagem));
			System.out.println("Mensagem Validada com sucesso: " + mensagem);
		} catch (Exception e) {
			System.out.println("Erro na validacao da mensagem: " + mensagem);
			Assert.assertTrue(false);
		}
	}
}
