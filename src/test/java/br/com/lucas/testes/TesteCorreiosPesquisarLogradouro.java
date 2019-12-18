package br.com.lucas.testes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = {"features/CorreiosPesquisarLogradouro.feature"}, glue = {	
			"" },  plugin = { "pretty" },monochrome = true, dryRun = false)
	public class TesteCorreiosPesquisarLogradouro {
	}