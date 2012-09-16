package br.com.bsitecnologia.dashboard.model;

// Generated 15/09/2012 10:17:48 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

import br.com.bsitecnologia.dashboard.util.BaseEntity;

/**
 * Colaborador generated by hbm2java
 */
@Entity
@Table(name = "Colaborador", catalog = "dashboard", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Colaborador implements Serializable, BaseEntity {
	
	private static final long serialVersionUID = -703435632161132437L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipe", nullable = false)
	private Equipe equipe;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colaboradorPai")
	private Colaborador colaboradorPai;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo", nullable = false)
	private Cargo cargo;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column(name = "localAlocacao", length = 45)
	private String localAlocacao;
	
	@Column(name = "telefone", length = 11)
	private String telefone;
	
	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;
	
	@Column(name = "remuneracao", precision = 8)
	private BigDecimal remuneracao;
	
	@Column(name = "senha", length = 20)
	private String senha;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaborador")
	private List<HistoricoRiscoProjeto> historicoRiscoProjetos = new ArrayList<HistoricoRiscoProjeto>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaboradorPai")
	private List<Colaborador> colaboradoresFilhos = new ArrayList<Colaborador>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaborador")
	private List<ColaboradorProjeto> colaboradorProjetos = new ArrayList<ColaboradorProjeto>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaborador")
	private List<EmailTemplateColaboradores> emailTemplateColaboradores = new ArrayList<EmailTemplateColaboradores>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaboradorAtribuido")
	private List<Impedimento> impedimentosAtribuidos = new ArrayList<Impedimento>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaborador")
	private List<HistoricoProjeto> historicoProjetos = new ArrayList<HistoricoProjeto>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaboradorAutor")
	private List<Impedimento> impedimentosCriados = new ArrayList<Impedimento>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colaborador")
	private List<Comentario> comentarios = new ArrayList<Comentario>(0);

	
	public Colaborador() {
	}

	public Colaborador(Equipe equipe, Cargo cargo, String email, String senha) {
		this.equipe = equipe;
		this.cargo = cargo;
		this.email = email;
		this.senha = senha;
	}

	public Colaborador(Integer id, Equipe equipe, Colaborador colaboradorPai,
			Cargo cargo, String nome, String localAlocacao, String telefone,
			String email, BigDecimal remuneracao, String senha,
			List<HistoricoRiscoProjeto> historicoRiscoProjetos,
			List<Colaborador> colaboradoresFilhos,
			List<ColaboradorProjeto> colaboradorProjetos,
			List<EmailTemplateColaboradores> emailTemplateColaboradores,
			List<Impedimento> impedimentosAtribuidos,
			List<HistoricoProjeto> historicoProjetos,
			List<Impedimento> impedimentosCriados, List<Comentario> comentarios) {
		super();
		this.id = id;
		this.equipe = equipe;
		this.colaboradorPai = colaboradorPai;
		this.cargo = cargo;
		this.nome = nome;
		this.localAlocacao = localAlocacao;
		this.telefone = telefone;
		this.email = email;
		this.remuneracao = remuneracao;
		this.senha = senha;
		this.historicoRiscoProjetos = historicoRiscoProjetos;
		this.colaboradoresFilhos = colaboradoresFilhos;
		this.colaboradorProjetos = colaboradorProjetos;
		this.emailTemplateColaboradores = emailTemplateColaboradores;
		this.impedimentosAtribuidos = impedimentosAtribuidos;
		this.historicoProjetos = historicoProjetos;
		this.impedimentosCriados = impedimentosCriados;
		this.comentarios = comentarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Colaborador getColaboradorPai() {
		return colaboradorPai;
	}

	public void setColaboradorPai(Colaborador colaboradorPai) {
		this.colaboradorPai = colaboradorPai;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalAlocacao() {
		return localAlocacao;
	}

	public void setLocalAlocacao(String localAlocacao) {
		this.localAlocacao = localAlocacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<HistoricoRiscoProjeto> getHistoricoRiscoProjetos() {
		return historicoRiscoProjetos;
	}

	public void setHistoricoRiscoProjetos(
			List<HistoricoRiscoProjeto> historicoRiscoProjetos) {
		this.historicoRiscoProjetos = historicoRiscoProjetos;
	}

	public List<Colaborador> getColaboradoresFilhos() {
		return colaboradoresFilhos;
	}

	public void setColaboradoresFilhos(List<Colaborador> colaboradoresFilhos) {
		this.colaboradoresFilhos = colaboradoresFilhos;
	}

	public List<ColaboradorProjeto> getColaboradorProjetos() {
		return colaboradorProjetos;
	}

	public void setColaboradorProjetos(List<ColaboradorProjeto> colaboradorProjetos) {
		this.colaboradorProjetos = colaboradorProjetos;
	}

	public List<EmailTemplateColaboradores> getEmailTemplateColaboradores() {
		return emailTemplateColaboradores;
	}

	public void setEmailTemplateColaboradores(
			List<EmailTemplateColaboradores> emailTemplateColaboradores) {
		this.emailTemplateColaboradores = emailTemplateColaboradores;
	}

	public List<Impedimento> getImpedimentosAtribuidos() {
		return impedimentosAtribuidos;
	}

	public void setImpedimentosAtribuidos(List<Impedimento> impedimentosAtribuidos) {
		this.impedimentosAtribuidos = impedimentosAtribuidos;
	}

	public List<HistoricoProjeto> getHistoricoProjetos() {
		return historicoProjetos;
	}

	public void setHistoricoProjetos(List<HistoricoProjeto> historicoProjetos) {
		this.historicoProjetos = historicoProjetos;
	}

	public List<Impedimento> getImpedimentosCriados() {
		return impedimentosCriados;
	}

	public void setImpedimentosCriados(List<Impedimento> impedimentosCriados) {
		this.impedimentosCriados = impedimentosCriados;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
