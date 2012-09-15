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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * AtorExterno generated by hbm2java
 */
@Entity
@Table(name = "AtorExterno", catalog = "dashboard")
public class AtorExterno implements Serializable {
	
	private static final long serialVersionUID = -8428235569394644796L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "nome", length = 127)
	private String nome;
	
	@Column(name = "email", length = 127)
	private String email;
	
	@Column(name = "telefone", length = 11)
	private String telefone;
	
	@Column(name = "cargo", length = 45)
	private String cargo;
	
	@Column(name = "empresa", length = 45)
	private String empresa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atorExterno")
	private List<Impedimento> impedimentos = new ArrayList<Impedimento>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atorExterno")
	private List<AtorExternoTransicaoStatus> atorExternoTransicaoStatus = new ArrayList<AtorExternoTransicaoStatus>(0);

	public AtorExterno() {
	}

	public AtorExterno(String nome, String email, String telefone,
			String cargo, String empresa, List<Impedimento> impedimentos,
			List<AtorExternoTransicaoStatus> atorExternoTransicaoStatus) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cargo = cargo;
		this.empresa = empresa;
		this.impedimentos = impedimentos;
		this.atorExternoTransicaoStatus = atorExternoTransicaoStatus;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<Impedimento> getImpedimentos() {
		return this.impedimentos;
	}

	public void setImpedimentos(List<Impedimento> impedimentos) {
		this.impedimentos = impedimentos;
	}

	public List<AtorExternoTransicaoStatus> getAtorExternoTransicaoStatus() {
		return this.atorExternoTransicaoStatus;
	}

	public void setAtorExternoTransicaoStatuses(List<AtorExternoTransicaoStatus> atorExternoTransicaoStatus) {
		this.atorExternoTransicaoStatus = atorExternoTransicaoStatus;
	}

}
