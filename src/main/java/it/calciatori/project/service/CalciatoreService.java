package it.calciatori.project.service;

import java.util.List;

import it.calciatori.project.model.Squadra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.calciatori.project.model.Calciatore;
import it.calciatori.project.repository.CalciatoreRepository;

@Service
public class CalciatoreService {
	
	@Autowired 
	private CalciatoreRepository calciatoreRepository;

	public List<Calciatore> findAllCalciatori() {
		return (List<Calciatore>) calciatoreRepository.findAll();
	}

	public List<Calciatore> findBySquadra_Id(Long squadra){
		return this.calciatoreRepository.findBySquadra_Id(squadra);
	}

	public Calciatore saveCalciatore(Calciatore calciatore) {
		return this.calciatoreRepository.save(calciatore);
	}

	public void delete(Calciatore calciatore){
		this.calciatoreRepository.delete(calciatore);
	}

	public Calciatore getById(Long id){
		return this.calciatoreRepository.getById(id);
	}
}
