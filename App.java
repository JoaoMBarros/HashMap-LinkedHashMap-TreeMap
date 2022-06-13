package Projeto;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.renderer.category.CategoryItemRenderer;

import javax.swing.*;

public class App {
	public static int indicaGrafico = 0;
	
    public static void main(String[] args) throws FileNotFoundException, VazioException {
		String menu = """
				Qual opcao voce deseja?
				1 - HashMap
				2 - LinkedHashMap
				3 - TreeMap
				4 - Graficos
				0 - Sair""";


		int res;

		do {
			res = opcaoMenu(menu);
			switch (res) {
				case 1 -> Menus.menuHashMap();
				case 2 -> Menus.menuLinkedHashMap();
				case 3 -> Menus.menuTreeMap();
				case 4 -> Menus.menuGrafico();
				default -> {
				}
			}
		} while (res != 0);
	}

	public static void montaGrafico(DefaultCategoryDataset dataset){

		String tempo;
		String grafico;
		tempo = (indicaGrafico == 1) ? "Tempo (em ms)" : "Tempo (em ns)";

		if(indicaGrafico == 1){
			grafico = "Tempo de insercao (em milisegundos)";
		}
		else if(indicaGrafico == 2){
			grafico = "Tempo de busca (em nanosegundos)";
		} else{
			grafico = "Tempo para exclusao (em nanosegundos)";
		}

		JFreeChart chart = ChartFactory.createLineChart(grafico,
				"arquivo",
				tempo,
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		chart.setBackgroundPaint(ChartColor.gray);
		chart.getTitle().setPaint(ChartColor.blue);
		CategoryPlot p = chart.getCategoryPlot();
		p.setForegroundAlpha(0.9f);
		p.setRangeGridlinePaint(ChartColor.red);
		p.setDomainGridlinesVisible(true);
		p.setDomainGridlinePaint(ChartColor.black);
		CategoryItemRenderer renderer = p.getRenderer();
		renderer.setSeriesPaint(2, ChartColor.blue);
		renderer.setSeriesPaint(1, ChartColor.red);
		renderer.setSeriesPaint(0, ChartColor.green);
		ChartFrame frame1 = new ChartFrame("Grafico de linhas",chart);
		frame1.setVisible(true);
		frame1.setSize(500,500);

	}

	public static int opcaoMenu(String menu) {

		// Auxiliar que guarda a opcao desejada pelo usuario
		int aux = 0;

		// Booleano que controla o while
		boolean inputAceito = false;

		while (!inputAceito) {

			// Cast do retorno pra string
			String aux1 = (String) JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.INFORMATION_MESSAGE,
					null, null, "");

			// Condicional pra caso o usuario clique pra sair do programa
			if (aux1 == null) {
				System.exit(0);
			}

			// Try catch para impedir o programa de crashar caso o usuario digite um
			// caractere invalido
			try {
				aux = Integer.parseInt(aux1);

				// Condicional que verifica se o numero inteiro digitado é valido
				if (aux < 0 || aux > 4) {
					JOptionPane.showMessageDialog(null, "Digite um valor valido", "Erro",
							JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					inputAceito = true;
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Digite um valor inteiro", "Erro", JOptionPane.INFORMATION_MESSAGE,
						null);
			}
		}

		return aux;
	}
}