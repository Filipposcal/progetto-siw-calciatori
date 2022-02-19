package it.calciatori.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.calciatori.project.model.Campionato;
import it.calciatori.project.repository.CampionatoRepository;

@Service
public class CampionatoService {
	
	@Autowired 
	private CampionatoRepository campionatoRepository;

	public List<Campionato> findAllCampionato() {
		return (List<Campionato>) campionatoRepository.findAll();
	}

    public Campionato saveCampionato(Campionato campionato) {
		return this.campionatoRepository.save(campionato);
    }

	public void delete(Campionato campionato){
		this.campionatoRepository.delete(campionato);
	}

	public Campionato getById(Long id){
		return this.campionatoRepository.getById(id);
	}
}
