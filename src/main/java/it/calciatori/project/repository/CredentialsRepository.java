package it.calciatori.project.repository;

import it.calciatori.project.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    public Optional<Credentials> findById(Long id);

    public Optional<Credentials> findByUsername(String username);
}
