package it.calciatori.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.calciatori.project.model.Procuratore;

@Repository
public interface ProcuratoreRepository extends JpaRepository<Procuratore, Long> {

}
