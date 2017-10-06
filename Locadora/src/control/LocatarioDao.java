/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.security.auth.login.Configuration;
import javax.swing.JOptionPane;
import model.Carros;
import model.Locatario;
import org.hibernate.HibernateException;

/**
 *
 * @author gui-f
 */
public class LocatarioDao {
    private Locatario cliente = new Locatario();
    private EntityManager em;
    
    /**
     * Método que retorna um locatário/cliente específico
     * @param cpf
     * @return 
     */
    public Locatario buscar(String cpf){
        return this.em.find(Locatario.class, cpf);
    }
    /**
     * Método que retorna todos os locatários/clientes cadastrados
     * @return 
     */
    public List<Locatario> buscarTodos(){
        return this.em.createQuery("SELECT C FROM LOCATARIO C").getResultList();
    }
    
    /**
     * Método para a inserção de dados do cliente no banco de dados
     * @param nome
     * @param cpf
     * @param cnh
     * @param validade
     * @param categoria 
     */
   public void inserirCliente(String nome, String cpf, int cnh, Date validade, String categoria){
       try{
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setCnh(cnh);
            cliente.setValidadeCnh(validade);
            cliente.setCatCnh(categoria);
            cliente.setStatus(cliente.verificarValidade(validade));
            cliente.setAtivo(true);
       
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            em.close();
       }catch(HibernateException e1){
           JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente.");
       }
   }
   
   /**
    * Método que atualiza cliente no banco de dados
    * @param nome
    * @param cpf
    * @param cnh
    * @param validade
    * @param categoria 
    */
   public void atualizarCliente(String nome, String cpf, int cnh, Date validade, String categoria){
       try{
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setCnh(cnh);
            cliente.setValidadeCnh(validade);
            cliente.setCatCnh(categoria);
            //Caso cliente atualize a CNH, já chama o método para verificar a validade da mesma
            cliente.setStatus(cliente.verificarValidade(validade));

            em.merge(cliente);
       }catch(HibernateException e1){
           JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente.");
       }
   }
   
   /**
    * Método que desativa cliente, não o permitindo fazer uma reserva
    * @param cpf 
    */
   public void desativarCliente(String cpf){
       LocatarioDao clienteDao = new LocatarioDao();
       cliente = clienteDao.buscar(cpf);
       try{
           cliente.setAtivo(false);
           
           em.getTransaction().begin();
           em.persist(cliente);
           em.getTransaction().commit();
           em.close();
       } catch(HibernateException e1){
           JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente.");
       }
   }
}
