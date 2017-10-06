/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.ClasseCarros;
import org.hibernate.HibernateException;

/**
 *
 * @author gui-f
 */
public class ClasseCarroDao {
    private ClasseCarros classeCarros = new ClasseCarros();
    private EntityManager em;
    
    public ClasseCarros buscarClasse(String nome){
        return this.em.find(ClasseCarros.class, nome);
    }
    
    public List<ClasseCarros> buscarTodos(){
        return this.em.createQuery("SELECT C FROM CLASSECARROS C").getResultList();
    }
    
    public void inserirClasse(String nome, float diaria){
        try{
            classeCarros.setNome(nome);
            classeCarros.setDiaria(diaria);
            
            em.getTransaction().begin();
            em.persist(classeCarros);
            em.getTransaction().commit();
            em.close();
        } catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente");
        }
    }
    
    public void atualizarClasse(String nome, float diaria){
        try{
            classeCarros.setNome(nome);
            classeCarros.setDiaria(diaria);
            
            em.getTransaction().begin();
            em.merge(classeCarros);
            em.close();
        } catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente");
        }
    }
    
    public void excluirClasse(ClasseCarros classe){
        try{
            em.getTransaction().begin();
            em.remove(classe);
            em.close();
        }catch(HibernateException e1){
            JOptionPane.showMessageDialog(null, "Algo deu errado, por favor tente novamente");
        }
    }
}