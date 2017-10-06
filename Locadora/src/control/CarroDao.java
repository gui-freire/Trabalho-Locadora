/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Enum.SituacaoVeiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Carros;
import org.hibernate.HibernateException;

/**
 *
 * @author gui-f
 */
public class CarroDao {
    private Carros carro = new Carros();
    private EntityManager em;
    
    /**
     * Método que busca um único carro pela placa
     * @param placa
     * @return 
     */
    public Carros buscarCarroPorPlaca(String placa){
        return this.em.find(Carros.class, placa);
    }
    
    /**
     * Busca uma lista de carros com base no nome
     * @param modelo
     * @return 
     */
    public List<Carros> buscarCarroPorModelo(String modelo){
        return this.em.createQuery("FROM CARROS WHERE modelo = " + modelo).getResultList();
    }
    /**
     * Busca todos os veículos cadastrados
     * @return 
     */
    public List<Carros> buscarTodos(){
        return this.em.createQuery("SELECT C FROM CARROS C").getResultList();
    }
    
    public List<String> buscarModelo(){
        return this.em.createQuery("SELECT C.MODELO FROM CARROS C").getResultList();
    }
    
    /**
     * Insere um novo veículo e já o configura para estar ativo
     * @param placa
     * @param modelo
     * @param ano
     * @param cor
     * @param quilometragem
     * @param descricao 
     */
    public void inserirCarros(String placa, String modelo, int ano, String cor, int quilometragem, String descricao){
        try{
            carro.setPlaca(placa);
            carro.setModelo(modelo);
            carro.setAno(ano);
            carro.setCor(cor);
            carro.setQuilometragem(quilometragem);
            carro.setDescrição(descricao);
            carro.setSituacao(SituacaoVeiculo.DISPONIVEL.toString());
            
            em.getTransaction().begin();
            em.persist(carro);
            em.getTransaction().commit();
            em.close();
        } catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente.");
        }
    }
    
    /**
     * Atualiza algum dado do carro
     * @param placa
     * @param modelo
     * @param ano
     * @param cor
     * @param quilometragem
     * @param descricao
     * @param situacao 
     */
    public void atualizarCarro(String placa, String modelo, int ano, String cor, int quilometragem, String descricao, String situacao){
        try{
            carro.setPlaca(placa);
            carro.setModelo(modelo);
            carro.setAno(ano);
            carro.setCor(cor);
            carro.setQuilometragem(quilometragem);
            carro.setDescrição(descricao);
            carro.setSituacao(situacao);
            
            em.getTransaction().begin();
            em.merge(carro);
            em.close();
        } catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente.");
        }
    }
    
    /**
     * Exclui algum carro da base
     * @param carros 
     */
    public void excluirCarro(Carros carros){
        try{
            em.getTransaction().begin();
            em.remove(carros);
            em.getTransaction().commit();
        }catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente");
        }
    }
    
    /**
     * Retorna um ComboBox populado com os modelos dos carros
     * @param cb 
     */
    public void carrosCombo(JComboBox cb){
        cb.removeAllItems();
        List<String> modelo = buscarModelo();
        int i = 0;
        cb.addItem(modelo);
    }
    
    /**
     * Retorna array com ano, cor, placa e quilometragem de um determinado modelo
     * @return 
     */
    public List<String> carrosLista(Carros carro){
        return this.em.createQuery("SELECT C.ANO, C.COR, C.PLACA, C.QUILOMETRAGEM FROM CARROS C WHERE C.MODELO = " + modelo).getResultList();
    }
}
