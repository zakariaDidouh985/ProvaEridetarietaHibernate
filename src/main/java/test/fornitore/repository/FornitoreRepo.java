package test.fornitore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.fornitore.model.Fornitore;

public interface FornitoreRepo extends JpaRepository<Fornitore, Long> {


    Fornitore findByEmail(String email);
}
