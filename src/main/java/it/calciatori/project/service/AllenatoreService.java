package it.calciatori.project.service;

import it.calciatori.project.model.Allenatore;
import it.calciatori.project.repository.AllenatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class AllenatoreService {

    @Autowired
    AllenatoreRepository allenatoreRepository;

    public List<Allenatore> findAll(){
        return this.allenatoreRepository.findAll();
    }

    public Allenatore saveAllenatore(Allenatore allenatore) {
        return this.allenatoreRepository.save(allenatore);
    }
    public void delete(Allenatore allenatore){
        this.allenatoreRepository.delete(allenatore);
    }
    public Allenatore getById(Long id){
        return this.allenatoreRepository.getById(id);
    }
}
