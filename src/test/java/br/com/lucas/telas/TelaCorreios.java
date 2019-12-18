package br.com.lucas.telas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import br.com.lucas.Utils.Planilha;
import br.com.lucas.Utils.Utils;
import br.com.lucas.mapeamento.MapeamentoCorreios;

public class TelaCorreios extends Utils{

	public void acessoSiteCorreios() {
		navega("http://www.correios.com.br");
	}

	public void buscoCep(String cep) {
		limpaEInsereTextoWait(cep, MapeamentoCorreios.getCampoPesquisarCep());
	}

	public void clicoNaLupa() {
		clicaWait(MapeamentoCorreios.getBotaoLupa());
	}

	public void validoEncontrouRegistros() {
		Set<String> janelas = getJanelas();
		for (String janela : janelas) {
			trocaParaAba(janela);
			if(getUrl().contains("buscacep")) {
				validoMensagemWait("DADOS ENCONTRADOS COM SUCESSO");
			}
		}
	}

	public void gravoPlanilhaOutputDosResultados(String cenario) {
		System.out.println("---- Gravando na Planilha Output: -----");
		Queue<String> resultados = new LinkedList<String>();
		int quantidadeLinhas = Utils.getQuantidadeElementos(MapeamentoCorreios.getLinhasTabela());
		int quantidadeColunas = 4;
		System.out.println("Cenário: " + cenario);
		System.out.println("Quantidade de Linhas: " + quantidadeLinhas);
		for(int i=1; i <=quantidadeLinhas;i++) {
			boolean descricao=false;
			if(i==1) { // nomes das colunas
				descricao=true;
			}
			String nome = getName(MapeamentoCorreios.getCampoTabela(i,1,descricao));
			String bairro = getName(MapeamentoCorreios.getCampoTabela(i,2,descricao));
			String localidade = getName(MapeamentoCorreios.getCampoTabela(i,3,descricao));
			String cep = getName(MapeamentoCorreios.getCampoTabela(i,4,descricao));
			System.out.printf("%-20s |",nome);
			System.out.printf("%-40s |",bairro);
			System.out.printf("%-40s |",localidade);
			System.out.printf("%-9s \n",cep);
			
			resultados.add(nome);
			resultados.add(bairro);
			resultados.add(localidade);
			resultados.add(cep);
		}
		Planilha p = new Planilha(System.getProperty("user.dir") + "\\planilhasOutput\\" + cenario + ".xls");
		p.grava(quantidadeLinhas,quantidadeColunas,resultados);
		System.out.println("---------------------------------------");
	}
}