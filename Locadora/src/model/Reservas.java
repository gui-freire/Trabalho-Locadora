/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gui-f
 */
@Entity
@Table(name="RESERVAS")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="numReserva")
    private long numReserva;
    @Column(name="qntdDiarias")
    private int qntdDiarias;
    @Column(name="dtLocacao")
    private Date dtLocacao;
    @Column(name="dtRetorno")
    private Date dtRetorno;
    @Column(name="kmRodados")
    private int kmRodados;
    @Column(name="multa")
    private float multa;
    @Column(name="situacao")
    private String situacao;
    @Column(name="valorTotal")
    private float valorTotal;
    //INFORMA SE CARRO FOI TRANSFERIDO DE FILIAL
    @Column(name="transferencia")
    private boolean transferencia;
    @Column(name="origemAluguel")
    private String origemAluguel;
    @Column(name="destinoAluguel")
    private String destinoAluguel;
    @Column(name="statusReserva")
    private boolean statusReserva;
    @Column(name="disponibilidade")
    private boolean disponibilidade;

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
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reservas[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the numReserva
     */
    public long getNumReserva() {
        return numReserva;
    }

    /**
     * @param numReserva the numReserva to set
     */
    public void setNumReserva(long numReserva) {
        this.numReserva = numReserva;
    }

    /**
     * @return the qntdDiarias
     */
    public int getQntdDiarias() {
        return qntdDiarias;
    }

    /**
     * @param qntdDiarias the qntdDiarias to set
     */
    public void setQntdDiarias(int qntdDiarias) {
        this.qntdDiarias = qntdDiarias;
    }

    /**
     * @return the dtLocacao
     */
    public Date getDtLocacao() {
        return dtLocacao;
    }

    /**
     * @param dtLocacao the dtLocacao to set
     */
    public void setDtLocacao(Date dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    /**
     * @return the dtRetorno
     */
    public Date getDtRetorno() {
        return dtRetorno;
    }

    /**
     * @param dtRetorno the dtRetorno to set
     */
    public void setDtRetorno(Date dtRetorno) {
        this.dtRetorno = dtRetorno;
    }

    /**
     * @return the kmRodados
     */
    public int getKmRodados() {
        return kmRodados;
    }

    /**
     * @param kmRodados the kmRodados to set
     */
    public void setKmRodados(int kmRodados) {
        this.kmRodados = kmRodados;
    }

    /**
     * @return the multa
     */
    public float getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(float multa) {
        this.multa = multa;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the transferencia
     */
    public boolean isTransferencia() {
        return transferencia;
    }

    /**
     * @param transferencia the transferencia to set
     */
    public void setTransferencia(boolean transferencia) {
        this.transferencia = transferencia;
    }

    /**
     * @return the origemAluguel
     */
    public String getOrigemAluguel() {
        return origemAluguel;
    }

    /**
     * @param origemAluguel the origemAluguel to set
     */
    public void setOrigemAluguel(String origemAluguel) {
        this.origemAluguel = origemAluguel;
    }

    /**
     * @return the destinoAluguel
     */
    public String getDestinoAluguel() {
        return destinoAluguel;
    }

    /**
     * @param destinoAluguel the destinoAluguel to set
     */
    public void setDestinoAluguel(String destinoAluguel) {
        this.destinoAluguel = destinoAluguel;
    }

    /**
     * @return the statusReserva
     */
    public boolean isStatusReserva() {
        return statusReserva;
    }

    /**
     * @param statusReserva the statusReserva to set
     */
    public void setStatusReserva(boolean statusReserva) {
        this.statusReserva = statusReserva;
    }

    /**
     * @return the disponibilidade
     */
    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    /**
     * @param disponibilidade the disponibilidade to set
     */
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
}
