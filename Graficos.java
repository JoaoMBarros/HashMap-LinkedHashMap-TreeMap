package Projeto;

import org.jfree.data.category.DefaultCategoryDataset;

import java.io.FileNotFoundException;

public class Graficos {

    public static void graficoInclusao(DefaultCategoryDataset dataset) throws FileNotFoundException {
        long duracaoHashMap = 0;
        long duracaoLinkedHashMap = 0;
        long duracaoTreeSet = 0;

        for(int i = 0; i < 10; i++){
            duracaoHashMap = Opcoes.criarTabela(1);
            dataset.addValue(duracaoHashMap/1000000,"HashMap",String.valueOf(i));
        }


        for(int i = 0; i < 10; i++){
            duracaoLinkedHashMap = Opcoes.criarTabela(2);
            dataset.addValue(duracaoLinkedHashMap/1000000,"LinkedHashMap",String.valueOf(i));
        }


        for(int i = 0; i < 10; i++){
            duracaoTreeSet = Opcoes.criarTabela(3);
            dataset.addValue(duracaoTreeSet/1000000, "TreeMap", String.valueOf(i));
        }

        App.indicaGrafico = 1;
        App.montaGrafico(dataset);

    }

    public static void graficoBusca() throws VazioException, FileNotFoundException {

        DefaultCategoryDataset datasetBusca = new DefaultCategoryDataset();
        long duracaoHashMap = 0;
        long duracaoLinkedHashMap = 0;
        long duracaoTreeSet = 0;

        for(int i = 0; i < 10; i++){
            duracaoHashMap = Opcoes.consultarPalavras(1, 0);
            datasetBusca.addValue(duracaoHashMap,"HashMap",String.valueOf(i));
        }


        for(int i = 0; i < 10; i++){
            duracaoLinkedHashMap = Opcoes.consultarPalavras(2, 0);
            datasetBusca.addValue(duracaoLinkedHashMap,"LinkedHashMap",String.valueOf(i));
        }


        for(int i = 0; i < 10; i++){
            duracaoTreeSet = Opcoes.consultarPalavras(3, 0);
            datasetBusca.addValue(duracaoTreeSet, "TreeMap", String.valueOf(i));
        }

        App.indicaGrafico = 2;
        App.montaGrafico(datasetBusca);

    }

    public static void graficoExclusao(DefaultCategoryDataset dataset) throws VazioException, FileNotFoundException {
        long duracaoHashMap = 0;
        long duracaoLinkedHashMap = 0;
        long duracaoTreeMap = 0;

        for(int i = 0; i < 10; i++){
            duracaoHashMap = Opcoes.excluirPalavras(1, 0);
            dataset.addValue(duracaoHashMap,"HashMap",String.valueOf(i));
        }

        for(int i = 0; i < 10; i++){
            duracaoLinkedHashMap = Opcoes.excluirPalavras(2, 0);
            dataset.addValue(duracaoLinkedHashMap,"LinkedHashMap",String.valueOf(i));
        }

        for(int i = 0; i < 10; i++){
            duracaoTreeMap = Opcoes.excluirPalavras(3, 0);
            dataset.addValue(duracaoTreeMap, "TreeMap", String.valueOf(i));
        }
        App.indicaGrafico = 3;
        App.montaGrafico(dataset);

    }
}
