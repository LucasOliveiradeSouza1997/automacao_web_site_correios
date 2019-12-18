package br.com.lucas.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Queue;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Planilha extends Utils {

	private static String ENDERECO_PLANILHA;
	private static FileOutputStream ARQUIVO;
	private static HSSFWorkbook PLANILHA;
	private static HSSFSheet  ABA;

	public Planilha(String endereco) {
		ENDERECO_PLANILHA = endereco;
	}

	public Planilha() {
	}

	private void criaPlanilha() {
		try {
			ARQUIVO = new FileOutputStream(new File(ENDERECO_PLANILHA));
			PLANILHA = new HSSFWorkbook();
			ABA = PLANILHA.createSheet("Output");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fecharPlanilha() {
		try {
			ARQUIVO.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvarPlanilha() {
		FileOutputStream arquivo;
		try {
			arquivo = new FileOutputStream(ENDERECO_PLANILHA);
			PLANILHA.write(arquivo);
		} catch (Exception e) {
		}
	}

	public void grava(int quantidadeLinhas, int quantidadeColunas, Queue<String> resultados) {
		criaPlanilha();
		for(int i=0;i<quantidadeLinhas;i++) {
            Row row = ABA.createRow(i);
			for(int j=0;j<quantidadeColunas;j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(resultados.remove());
			}
		}
		salvarPlanilha();
		fecharPlanilha();
	}
}