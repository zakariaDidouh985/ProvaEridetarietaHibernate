package test.fornitore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.fornitore.model.Utente;

import java.util.Optional;

public interface UtenteRepo extends JpaRepository<Utente, Long> {

    Optional<Utente> findById (Long id);
    Utente findByNome (String nome);
    boolean existsByEmail(String email);
    Utente findByEmail(String email);

}
