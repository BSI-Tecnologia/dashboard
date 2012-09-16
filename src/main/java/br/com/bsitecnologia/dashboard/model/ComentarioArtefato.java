package br.com.bsitecnologia.dashboard.model;

// Generated 15/09/2012 10:17:48 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bsitecnologia.dashboard.util.BaseEntity;

/**
 * ComentarioArtefato generated by hbm2java
 */
@Entity
@Table(name = "ComentarioArtefato", catalog = "dashboard")
public class ComentarioArtefato implements Serializable, BaseEntity {
	
	private static final long serialVersionUID = -510396667327625546L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artefato", nullable = false)
	private Artefato artefato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comentario", nullable = false)
	private Comentario comentario;

	
	public ComentarioArtefato() {
	}

	public ComentarioArtefato(Artefato artefato, Comentario comentario) {
		this.artefato = artefato;
		this.comentario = comentario;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Artefato getArtefato() {
		return this.artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
	}

	public Comentario getComentario() {
		return this.comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

}
