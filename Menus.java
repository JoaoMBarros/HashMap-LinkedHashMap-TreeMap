package Projeto;

import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Menus {

    private static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    public static String[] palavrasAparecer = new String[10];


    private static String menu = """
                Qual opcao voce deseja?
                1 - Criar tabela
                2 - Consultar tabelas
                3 - Excluir nomes das tabelas
                0 - Voltar""";
    private static String menuGrafico = """
                Qual opcao voce deseja?
                1 - Grafico inclusao
                2 - Grafico busca
                3 - Grafico exclusao
                0 - Voltar""";

    public static void menuHashMap() throws FileNotFoundException, VazioException {
        int res;
        do{
            res = App.opcaoMenu(menu);
            switch (res) {
                case 1 -> {
                    int tempoMs = (int) Opcoes.criarTabela(1) / 10000000;
                }
                case 2 -> {
                    try{
                        Opcoes.consultarPalavras(1, 1);
                        JOptionPane.showMessageDialog(null, palavrasAparecer, "Palavras encontradas", JOptionPane.INFORMATION_MESSAGE);
                    }catch (VazioException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                case 3 -> {
                    try {
                        Opcoes.excluirPalavras(1, 1);
                        JOptionPane.showMessageDialog(null, palavrasAparecer, "Palavras excluidas", JOptionPane.INFORMATION_MESSAGE);
                    }catch (VazioException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                default -> {
                }
            }
        }while(res != 0);
    }

    public static void menuLinkedHashMap() throws FileNotFoundException, VazioException {
        int res;
        do{
            res = App.opcaoMenu(menu);
            switch (res){
                case 1 -> Opcoes.criarTabela(2);
                case 2 -> {
                    try {
                        Opcoes.consultarPalavras(2, 1);
                        JOptionPane.showMessageDialog(null, palavrasAparecer, "Palavras encontradas", JOptionPane.INFORMATION_MESSAGE);
                    }catch (VazioException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case 3 -> {
                    try {
                        Opcoes.excluirPalavras(2, 1);
                        JOptionPane.showMessageDialog(null, palavrasAparecer, "Palavras excluidas", JOptionPane.INFORMATION_MESSAGE);
                    }catch (VazioException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                default -> {
                }
            }
        }while(res != 0);
    }

    public static void menuTreeMap() throws FileNotFoundException, VazioException {
        int res;
        do{
            res = App.opcaoMenu(menu);
            switch (res){
                case 1 -> Opcoes.criarTabela(3);
                case 2 -> {
                    try {
                        Opcoes.consultarPalavras(3, 1);
                        JOptionPane.showMessageDialog(null, palavrasAparecer, "Palavras encontradas", JOptionPane.INFORMATION_MESSAGE);
                    }catch (VazioException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                case 3 -> {
                    try {
                        Opcoes.excluirPalavras(3, 1);
                        JOptionPane.showMessageDialog(null, palavrasAparecer, "Palavras excluidas", JOptionPane.INFORMATION_MESSAGE);
                    }catch (VazioException e){
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                default -> {
                }
            }
        }while(res != 0);
    }

    public static void menuGrafico() throws FileNotFoundException, VazioException {
        int res;
        do{
            res = App.opcaoMenu(menuGrafico);
            switch (res){
                case 1 -> Graficos.graficoInclusao(dataset);
                case 2 -> Graficos.graficoBusca();
                case 3 -> Graficos.graficoExclusao(dataset);
                default -> {
                }
            }
        }while(res != 0);
    }
}