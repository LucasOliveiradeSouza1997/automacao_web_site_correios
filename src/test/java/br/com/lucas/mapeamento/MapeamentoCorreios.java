package br.com.lucas.mapeamento;

import org.openqa.selenium.By;

public final class MapeamentoCorreios {
	
	private static By campoPesquisarCep = By.id("acesso-busca");
	private static By botaoLupa= By.xpath("//*[@id='acesso-busca']/../button");
	private static By linhasTabela = By.xpath("//*[@id=\"Geral\"]/../table/tbody/tr");

	public static By getCampoPesquisarCep() {
		return campoPesquisarCep;
	}

	public static By getBotaoLupa() {
		return botaoLupa;
	}

	public static By getCampoTabela(int i, int j, boolean descricao) {
		if(descricao) {
			return By.xpath("//form[@id='Geral']/../table//tr["+i+"]/th["+j+"]");
		}
		return By.xpath("//form[@id='Geral']/../table//tr["+i+"]/td["+j+"]");
	}

	public static By getLinhasTabela() {
		return linhasTabela;
	}
}