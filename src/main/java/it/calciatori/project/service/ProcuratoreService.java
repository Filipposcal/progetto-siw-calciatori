package it.calciatori.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.calciatori.project.model.Procuratore;
import it.calciatori.project.repository.ProcuratoreRepository;

@Service
public class ProcuratoreService {
	
	@Autowired 
	private ProcuratoreRepository procuratoreRepository;

	public List<Procuratore> findAllProcuratore() {
		return (List<Procuratore>) procuratoreRepository.findAll();
	}

    public Procuratore saveProcuratore(Procuratore procuratore) {
		return this.procuratoreRepository.save(procuratore);
    }

	public void delete(Procuratore procuratore){
		this.procuratoreRepository.delete(procuratore);
	}

	public Procuratore getById(Long id){
		return this.procuratoreRepository.getById(id);
	}
}
