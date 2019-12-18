package br.com.lucas.testes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = {"features/CorreiosPesquisarCEP.feature"}, glue = {	
			"" },  plugin = { "pretty" },monochrome = true, dryRun = false)
	public class TesteCorreiosPesquisarCEP {
	}