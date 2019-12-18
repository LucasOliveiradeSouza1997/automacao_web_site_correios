package br.com.lucas.beforeAndAfter;

import br.com.lucas.Utils.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class BeforeAndAfter extends Utils {
	

	@Before
	public void inicializa(Scenario scenario) {
		System.out.println("Iniciando");
	}

	@After
	public void finaliza(Scenario scenario) {
		encerra();
	}
}
