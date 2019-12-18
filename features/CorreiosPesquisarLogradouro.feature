Feature: Correios Pesquisar Logradouro

  Scenario Outline: Correios Pesquisar Logradouro

	Given acesso o site do correios
	When busco Cep/Endereco "<endereco>"
	And clico na lupa para pesquisar
	Then valido que encontrou registros
	And gravo na planilha output dos resultados "<cenario>"
	
	
	Examples: 
	| endereco                          |cenario                    |
	| Rua Berlim Aparecida de Goiânia/GO|CorreiosPesquisarLogradouro|