package it.calciatori.project.repository;

import java.util.List;

import it.calciatori.project.model.Squadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.calciatori.project.model.Calciatore;


@Repository
public interface CalciatoreRepository extends JpaRepository<Calciatore, Long> {
	
	List<Calciatore> findBySquadra_Id(Long squadra);
}
