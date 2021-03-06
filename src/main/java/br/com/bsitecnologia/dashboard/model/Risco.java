package br.com.bsitecnologia.dashboard.model;

// Generated 15/09/2012 10:17:48 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bsitecnologia.dashboard.util.BaseEntity;

/**
 * Risco generated by hbm2java
 */
@Entity
@Table(name = "Risco", catalog = "dashboard")
public class Risco implements Serializable, BaseEntity {
	
	private static final long serialVersionUID = -799370763158142999L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "impacto", nullable = false)
	private Impacto impacto;
	
	@Column(name = "probabilidade", nullable = false)
	private int probabilidade;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "risco")
	private List<RiscoProjeto> riscoProjetos = new ArrayList<RiscoProjeto>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "risco")
	private List<Impedimento> impedimentos = new ArrayList<Impedimento>(0);
	

	public Risco() {
	}

	public Risco(Impacto impacto, int probabilidade) {
		this.impacto = impacto;
		this.probabilidade = probabilidade;
	}

	public Risco(Impacto impacto, int probabilidade,
			List<RiscoProjeto> riscoProjetos, List<Impedimento> impedimentos) {
		this.impacto = impacto;
		this.probabilidade = probabilidade;
		this.riscoProjetos = riscoProjetos;
		this.impedimentos = impedimentos;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Impacto getImpacto() {
		return this.impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}

	public int getProbabilidade() {
		return this.probabilidade;
	}

	public void setProbabilidade(int probabilidade) {
		this.probabilidade = probabilidade;
	}

	public List<RiscoProjeto> getRiscoProjetos() {
		return this.riscoProjetos;
	}

	public void setRiscoProjetos(List<RiscoProjeto> riscoProjetos) {
		this.riscoProjetos = riscoProjetos;
	}

	public List<Impedimento> getImpedimentos() {
		return this.impedimentos;
	}

	public void setImpedimentos(List<Impedimento> impedimentos) {
		this.impedimentos = impedimentos;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getEntityDescription() {
		return nome;
	}

}
