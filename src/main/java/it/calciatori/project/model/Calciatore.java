package it.calciatori.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "calciatore")
public class Calciatore implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "ruolo")
	private String ruolo;
	
	@ManyToOne
	@JoinColumn(name = "id_squadra", nullable = false)
	private Squadra squadra;
	
	@ManyToOne
	@JoinColumn(name = "id_procuratore", nullable = false)
	private Procuratore procuratore;



	public Calciatore() {
	}


	public Calciatore(String nome, String cognome, String ruolo, Squadra squadra, Procuratore procuratore) {
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.squadra = squadra;
		this.procuratore = procuratore;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public Procuratore getProcuratore() {
		return procuratore;
	}

	public void setProcuratore(Procuratore procuratore) {
		this.procuratore = procuratore;
	}
}
