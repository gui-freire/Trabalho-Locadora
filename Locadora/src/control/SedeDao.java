/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.Sede;
import org.hibernate.HibernateException;

/**
 *
 * @author gui-f
 */
public class SedeDao {
    
    Sede sede = new Sede();
    EntityManager em;
    
    public Sede buscar(int id){
        return this.em.find(Sede.class, id);
    }
    
    public List<Sede> buscarTodos(){
        return this.em.createQuery("SELECT C FROM SEDE C").getResultList();
    }
    
    public void inserirSede(Long id, String nome, String endereco, String telefone, String gerente, float multa){
        try{
            sede.setId(id);
            sede.setNome(nome);
            sede.setEndereco(endereco);
            sede.setTelefone(telefone);
            sede.setGerente(gerente);
            sede.setMulta(multa);
        
            em.getTransaction().begin();
            em.persist(sede);
            em.getTransaction().commit();
            em.close();
        }catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente");
        }
    }
    
    public void atualizarSede(Long id, String nome, String endereco, String telefone, String gerente, float multa){
        try{
            sede.setId(id);
            sede.setNome(nome);
            sede.setEndereco(endereco);
            sede.setTelefone(telefone);
            sede.setGerente(gerente);
            sede.setMulta(multa);
        
            em.merge(sede);
        }catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente");
        }
    }
    
    public void excluirSede(Sede sede){
        try{
            em.getTransaction().begin();
            em.remove(sede);
            em.close();
        }catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente");
    }
}

}
