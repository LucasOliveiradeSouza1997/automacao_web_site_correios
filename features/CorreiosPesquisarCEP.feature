Feature: Correios Pesquisar CEP

  Scenario Outline: Correios Pesquisar CEP

	Given acesso o site do correios
	When busco Cep/Endereco "<cep>"
	And clico na lupa para pesquisar
	Then valido que encontrou registros
	And gravo na planilha output dos resultados "<cenario>" 
	
	
	Examples: 
	| cep       |cenario              |
	| 06395-440 |CorreiosPesquisarCEP |