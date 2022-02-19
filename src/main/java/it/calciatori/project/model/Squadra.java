package it.calciatori.project.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "squadra")
public class Squadra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;


	@Column(name = "nome")
	private String nome;
	
	@Column(name = "nazionalita")
	private String nazionalita;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "squadra")
	private Set<Calciatore> calciatore;
	

	
	@ManyToOne
	@JoinColumn(name = "id_campionato", nullable = false)
	private Campionato campionato;
	
	@ManyToOne
	@JoinColumn(name = "id_allenatore", nullable = false)
	private Allenatore allenatore;
	
	
	
	
	

	public Squadra() {
	}
	

	public Squadra(String nome, String nazionalita) {

		this.nome = nome;
		this.nazionalita = nazionalita;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getNazionalita() {
		return nazionalita;
	}


	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	public Campionato getCampionato() {
		return campionato;
	}



	public void setCampionato(Campionato campionato) {
		this.campionato = campionato;
	}


	public Allenatore getAllenatore() {
		return allenatore;
	}


	public void setAllenatore(Allenatore allenatore) {
		this.allenatore = allenatore;
	}
	
	




	

}
