package br.com.bsitecnologia.dashboard.model;
// Generated 01/09/2012 11:28:22 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HistoricoProjeto generated by hbm2java
 */
@Entity
@Table(name="HistoricoProjeto"
    ,catalog="dashboard"
)
public class HistoricoProjeto  implements java.io.Serializable {


     private Integer id;
     private Projeto projeto;
     private TransicaoStatus transicaoStatus;
     private Colaborador colaborador;
     private AtorExternoTransicaoStatus atorExternoTransicaoStatus;
     private Date dataInicio;
     private Date dataFim;
     private Date dataPrevisaoConclusao;
     private BigDecimal orcamento;
     private BigDecimal custo;
     private Date dataAlteracao;

    public HistoricoProjeto() {
    }

	
    public HistoricoProjeto(Projeto projeto, TransicaoStatus transicaoStatus, Colaborador colaborador) {
        this.projeto = projeto;
        this.transicaoStatus = transicaoStatus;
        this.colaborador = colaborador;
    }
    public HistoricoProjeto(Projeto projeto, TransicaoStatus transicaoStatus, Colaborador colaborador, AtorExternoTransicaoStatus atorExternoTransicaoStatus, Date dataInicio, Date dataFim, Date dataPrevisaoConclusao, BigDecimal orcamento, BigDecimal custo, Date dataAlteracao) {
       this.projeto = projeto;
       this.transicaoStatus = transicaoStatus;
       this.colaborador = colaborador;
       this.atorExternoTransicaoStatus = atorExternoTransicaoStatus;
       this.dataInicio = dataInicio;
       this.dataFim = dataFim;
       this.dataPrevisaoConclusao = dataPrevisaoConclusao;
       this.orcamento = orcamento;
       this.custo = custo;
       this.dataAlteracao = dataAlteracao;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="projeto", nullable=false)
    public Projeto getProjeto() {
        return this.projeto;
    }
    
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="transicaoStatus", nullable=false)
    public TransicaoStatus getTransicaoStatus() {
        return this.transicaoStatus;
    }
    
    public void setTransicaoStatus(TransicaoStatus transicaoStatus) {
        this.transicaoStatus = transicaoStatus;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="colaborador", nullable=false)
    public Colaborador getColaborador() {
        return this.colaborador;
    }
    
    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="atorExternoTransicaoStatus")
    public AtorExternoTransicaoStatus getAtorExternoTransicaoStatus() {
        return this.atorExternoTransicaoStatus;
    }
    
    public void setAtorExternoTransicaoStatus(AtorExternoTransicaoStatus atorExternoTransicaoStatus) {
        this.atorExternoTransicaoStatus = atorExternoTransicaoStatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataInicio", length=10)
    public Date getDataInicio() {
        return this.dataInicio;
    }
    
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataFim", length=10)
    public Date getDataFim() {
        return this.dataFim;
    }
    
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataPrevisaoConclusao", length=10)
    public Date getDataPrevisaoConclusao() {
        return this.dataPrevisaoConclusao;
    }
    
    public void setDataPrevisaoConclusao(Date dataPrevisaoConclusao) {
        this.dataPrevisaoConclusao = dataPrevisaoConclusao;
    }

    
    @Column(name="orcamento", precision=11)
    public BigDecimal getOrcamento() {
        return this.orcamento;
    }
    
    public void setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
    }

    
    @Column(name="custo", precision=11)
    public BigDecimal getCusto() {
        return this.custo;
    }
    
    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dataAlteracao", length=19)
    public Date getDataAlteracao() {
        return this.dataAlteracao;
    }
    
    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }




}


