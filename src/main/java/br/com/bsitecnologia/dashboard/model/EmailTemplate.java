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
 * EmailTemplate generated by hbm2java
 */
@Entity
@Table(name = "EmailTemplate", catalog = "dashboard")
public class EmailTemplate implements Serializable, BaseEntity {
	
	private static final long serialVersionUID = 7668069799964210190L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alerta", nullable = false)
	private Alerta alerta;

	@Column(name = "conteudoEmail", nullable = false, length = 2000)
	private String conteudoEmail;
	
	@Column(name = "tituloEmail", nullable = false, length = 50)
	private String tituloEmail;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emailTemplate")
	private List<EmailTemplateColaboradores> emailTemplateColaboradores = new ArrayList<EmailTemplateColaboradores>(0);

	public EmailTemplate() {
	}

	public EmailTemplate(Alerta alerta, String conteudoEmail, String tituloEmail) {
		this.alerta = alerta;
		this.conteudoEmail = conteudoEmail;
		this.tituloEmail = tituloEmail;
	}

	public EmailTemplate(Integer id, Alerta alerta, String conteudoEmail,
			String tituloEmail,
			List<EmailTemplateColaboradores> emailTemplateColaboradores) {
		this.id = id;
		this.alerta = alerta;
		this.conteudoEmail = conteudoEmail;
		this.tituloEmail = tituloEmail;
		this.emailTemplateColaboradores = emailTemplateColaboradores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alerta getAlerta() {
		return alerta;
	}

	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}

	public String getConteudoEmail() {
		return conteudoEmail;
	}

	public void setConteudoEmail(String conteudoEmail) {
		this.conteudoEmail = conteudoEmail;
	}

	public String getTituloEmail() {
		return tituloEmail;
	}

	public void setTituloEmail(String tituloEmail) {
		this.tituloEmail = tituloEmail;
	}

	public List<EmailTemplateColaboradores> getEmailTemplateColaboradores() {
		return emailTemplateColaboradores;
	}

	public void setEmailTemplateColaboradores(
			List<EmailTemplateColaboradores> emailTemplateColaboradores) {
		this.emailTemplateColaboradores = emailTemplateColaboradores;
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
