/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.CarroDao;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gui-f
 */
public class ListModel {

    //Método de Visualização Grid
    public void carregaGrid(String modelo) {

        //Variavel do Grid
        String[] cabecalho;
        String[][] linha;
        JScrollPane barraTabela;

        // CABEÇALHO DA DATATABLE.
        cabecalho = new String[]{"Ano", "Cor", "Placa", "Quilometragem"};

        // CRIA A TABELA.t
        JTable listaRegistro = new JTable();

        // CRIA UM MODELO DE TABELA PADRÃO QUE RECEBE COM VALOR A TABELA CRIADA ANTERIORMENTE.
        DefaultTableModel dtm = (DefaultTableModel) listaRegistro.getModel();

        // IDENTIFICA O CABEÇALHO DAS COLUNAS DA TABELA PADRÃO
        dtm.setColumnIdentifiers(cabecalho);
        listaRegistro.getColumnModel().getColumn(1).setPreferredWidth(300);
        // CRIA UM CONJUTO DE DADOS QUE RECEBERÁ, ATRAVES DO RECORDSET, OS DADOS DA TABELA.
        CarroDao dao = new CarroDao();
        List<Carros> carros = dao.carrosLista(modelo);

        // CRIA UMA VARIAVEL  QUE RECEBERÁ A QUANTIDADE DE COLUNAS RETORNADAS.
        int colNo = rsmd.getColumnCount();

        if (rs != null) {
            // LÊ O RECORDSET
            while (rs.next()) {
                // PREENCHE AS LINHAS DA TABELA.
                Object[] registros = new Object[colNo];
                for (int i = 0; i < colNo; i++) {
                    registros[i] = rs.getObject(i + 1);
                }

                // ADICIONA AS LINHAS À TABELA.
                dtm.addRow(registros);

            }
            listaRegistro.setModel(dtm);
            barraTabela = new JScrollPane(listaRegistro);
            barraTabela.setBounds(68, 236, 350, 150);
            getContentPane().add(barraTabela);

        }

    }
    catch (SQLException e1

    
        ) {
			e1.printStackTrace();
    }
}

}
