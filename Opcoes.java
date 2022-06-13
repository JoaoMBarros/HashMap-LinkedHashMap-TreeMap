package Projeto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Opcoes {
	public static TreeMap<String,Integer> teste3 = new TreeMap<String,Integer>();
	public static HashMap<String, Integer> counterMap = new HashMap<>();
	public static LinkedHashMap<String, Integer> lm = new LinkedHashMap<>();


	public static long criarTabela(int opc) throws FileNotFoundException {

		long startTime;
		long estimatedTime = 0;
		Scanner s = new Scanner(new FileReader("src/Projeto/leipzig100k.txt"));
		ArrayList<String> ArrayTemp = new ArrayList<>();

		while (s.hasNext()) {
			String next = s.next();
			next = next.replaceAll("\\p{Punct}", ""); //Token pra retirar a pontuacao
			next = next.replaceAll("[0-9]", ""); //Apaga os numeros
			ArrayTemp.add(next);
		}

		switch (opc) {
			case 1 -> {
				int i = 0;
				startTime = System.nanoTime();
				for (String a : ArrayTemp) {
					counterMap.put(a, i);
					i++;
				}
				estimatedTime = System.nanoTime() - startTime;
			}
			case 2 -> {
				int k = 0;
				startTime = System.nanoTime();
				for (String a : ArrayTemp) {
					lm.put(a, k);
					k++;
				}
				estimatedTime = System.nanoTime() - startTime;
			}
			case 3 -> {
				int j = 0;
				startTime = System.nanoTime();
				for (String a : ArrayTemp) {
					teste3.put(a, j);
					j++;
				}
				estimatedTime = System.nanoTime() - startTime;
			}
			default -> {
			}
		}
		return estimatedTime;
	}

	public static long consultarPalavras(int opc, int indicador) throws VazioException, FileNotFoundException {
		String[] palavras = {"Lisbon", "NASA", "Kyunghee", "Konkuk","Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
		long startTime;
		long estimatedTime = 0;

		switch (opc) {
			//Caso seja HashMap
			case 1 -> {
				//Mostra as palavras encontradas caso o pedido não seja pra montagem de grafico
				if(indicador != 0){
					//Caso tente procurar sem criar antes
					if(counterMap.isEmpty()){
						throw new VazioException();
					}
					int k = 0;
					for (String a : palavras) {
						Menus.palavrasAparecer[k] = (counterMap.containsKey(a)) ?
						a : null;
						k++;
					}
				}else {
					if(counterMap.isEmpty()){
						criarTabela(1);
					}
					startTime = System.nanoTime();
					for (String a : palavras) {
						counterMap.get(a);
					}
					estimatedTime = System.nanoTime() - startTime;
				}
			}

			case 2 -> {
				//Mostra as palavras encontradas caso o pedido não seja pra montagem de grafico
				if(indicador != 0){
					if(lm.isEmpty()){
						throw new VazioException();
					}
					int k = 0;
					for (String a : palavras) {
						Menus.palavrasAparecer[k] = (lm.containsKey(a)) ?
								a : null;
						k++;
					}
				}else {
					if (lm.isEmpty()) {
						criarTabela(2);
					}
					startTime = System.nanoTime();
					for (int j = 0; j < 10; j++) {
						for (int k = 0; k < 10; k++) {
							lm.get(palavras[k]);
						}
					}
					estimatedTime = System.nanoTime() - startTime;
				}
			}

			case 3 -> {
				//Mostra as palavras encontradas caso o pedido não seja pra montagem de grafico
				if (indicador != 0) {
					int k = 0;
					if (teste3.isEmpty()) {
						throw new VazioException();
					}
					for (String a : palavras) {
						Menus.palavrasAparecer[k] = (teste3.containsKey(a)) ?
								a : null;
						k++;
					}
				} else {
					if (teste3.isEmpty()) {
						criarTabela(3);
					}
					startTime = System.nanoTime();
					for (int j = 0; j < 10; j++) {
						for (int k = 0; k < 10; k++) {
							teste3.get(palavras[k]);
						}
					}
					estimatedTime = System.nanoTime() - startTime;
				}
			}

			default -> {
			}
		}
		return estimatedTime;
	}
	
	public static long excluirPalavras(int opc, int indicador) throws VazioException, FileNotFoundException {
		String[] palavras = {"Lisbon", "NASA", "Kyunghee", "Konkuk","Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
		long startTime = 0;
		long estimatedTime = 0;

		switch (opc) {
			case 1 -> {


				//Mostra as palavras excluidas caso o pedido não seja pra montagem de grafico
				if (indicador != 0) {
					if (counterMap.isEmpty()) {
						throw new VazioException();
					}
					int k = 0;
					for (String a : palavras) {
						Menus.palavrasAparecer[k] = (counterMap.containsKey(a)) ?
								a : null;
						k++;
						counterMap.remove(a);
					}
				} else {
					if (counterMap.isEmpty()) {
						criarTabela(1);
					}
					HashMap<String, Integer> aux = new HashMap<>(counterMap);
					startTime = System.nanoTime();
					for (String a : palavras) {
						aux.remove(a);
					}
					estimatedTime = System.nanoTime() - startTime;
				}
			}

			case 2 -> {

				//Mostra as palavras excluidas caso o pedido não seja pra montagem de grafico
				if(indicador != 0){
					if (lm.isEmpty()) {
						throw new VazioException();
					}
					int k = 0;
					for (String a : palavras) {
						Menus.palavrasAparecer[k] = (lm.containsKey(a)) ?
								a : null;
						k++;
						lm.remove(a);
					}
				}else {
					if (lm.isEmpty()) {
						criarTabela(2);
					}
					LinkedHashMap<String, Integer> auxLM;
					auxLM = lm;
					startTime = System.nanoTime();
					for (int k = 0; k < 10; k++) {
						auxLM.remove(palavras[k]);
					}
					estimatedTime = System.nanoTime() - startTime;
				}
			}

			case 3 -> {
				//Mostra as palavras excluidas caso o pedido não seja pra montagem de grafico
				if(indicador != 0){
					if (teste3.isEmpty()) {
						throw new VazioException();
					}
					int k = 0;
					for (String a : palavras) {
						Menus.palavrasAparecer[k] = (teste3.containsKey(a)) ?
								a : null;
						k++;
						teste3.remove(a);
					}
				}else {
					if (teste3.isEmpty()) {
						criarTabela(3);
					}
					TreeMap<String, Integer> temp;
					temp = teste3;
					startTime = System.nanoTime();
					for (int k = 0; k < 10; k++) {
						temp.remove(palavras[k]);
					}
					estimatedTime = System.nanoTime() - startTime;
				}
			}
			default -> {
			}
		}
		return estimatedTime;
	}
}