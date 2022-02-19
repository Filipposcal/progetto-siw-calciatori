package it.calciatori.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.calciatori.project.model.Squadra;

@Repository
public interface SquadraRepository extends JpaRepository<Squadra, Long> {

}
