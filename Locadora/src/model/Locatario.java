/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.scene.input.DataFormat;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gui-f
 */
@Entity
@Table(name="LOCATARIO")
public class Locatario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="cpf")
    private String cpf;
    @Column(name="cnh")
    private int cnh;
    @Column(name="validadeCnh")
    private Date validadeCnh;
    @Column(name="catCnh")
    private String catCnh;
    private boolean status;
    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locatario)) {
            return false;
        }
        Locatario other = (Locatario) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Locatario[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the cnh
     */
    public int getCnh() {
        return cnh;
    }

    /**
     * @param cnh the cnh to set
     */
    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    /**
     * @return the validadeCnh
     */
    public Date getValidadeCnh() {
        return validadeCnh;
    }

    /**
     * @param validadeCnh the validadeCnh to set
     */
    public void setValidadeCnh(Date validadeCnh) {
        this.validadeCnh = validadeCnh;
    }

    /**
     * @return the catCnh
     */
    public String getCatCnh() {
        return catCnh;
    }

    /**
     * @param catCnh the catCnh to set
     */
    public void setCatCnh(String catCnh) {
        this.catCnh = catCnh;
    }

    /**
     * @return the status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    /**
     * Método que verifica se a CNH do cliente já venceu
     * @param validade
     * @return 
     */
    public boolean verificarValidade(Date validade){
        Date date = new Date();
        if(validade.before(date)){
            return true;
        }else{
            return false;
        }
    }
    
    public String dataParaString(Date validade){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(validade);
        return data;
    }
}
