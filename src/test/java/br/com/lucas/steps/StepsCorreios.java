package br.com.lucas.steps;

import br.com.lucas.telas.TelaCorreios;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsCorreios {

	private static TelaCorreios telaCorreios;

	public StepsCorreios() {
		telaCorreios = new TelaCorreios();
	}

	@Given("^acesso o site do correios$")
	public void acesso_o_site_do_correios() throws Throwable {
		telaCorreios.acessoSiteCorreios();
	}

	@When("^busco Cep/Endereco \"([^\"]*)\"$")
	public void busco_Cep(String cep) throws Throwable {
		telaCorreios.buscoCep(cep);
	}
	
	
	@And("^clico na lupa para pesquisar$")
	public void clico_na_lupa_para_pesquisar() throws Throwable {
		telaCorreios.clicoNaLupa();
	}
	
	@Then("^valido que encontrou registros$")
	public void valido_que_encontrou_registros() throws Throwable {
		telaCorreios.validoEncontrouRegistros();
	}
	
	@And("^gravo na planilha output dos resultados \"([^\"]*)\"$")
	public void gravo_na_planilha_output_dos_resultados(String cenario) throws Throwable {
		telaCorreios.gravoPlanilhaOutputDosResultados(cenario);
	}

}
