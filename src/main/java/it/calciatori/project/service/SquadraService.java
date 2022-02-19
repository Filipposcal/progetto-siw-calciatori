package it.calciatori.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.calciatori.project.model.Squadra;
import it.calciatori.project.repository.SquadraRepository;

@Service
public class SquadraService {
	
	@Autowired 
	private SquadraRepository squadraRepository;

	public List<Squadra> findAllSquadra() {
		return (List<Squadra>) squadraRepository.findAll();
	}

    public Squadra saveSquadra(Squadra squadra) {
		return this.squadraRepository.save(squadra);
    }

	public void delete(Squadra squadra){
		this.squadraRepository.delete(squadra);
	}

	public Squadra getById(Long id){
		return this.squadraRepository.getById(id);
	}
}
