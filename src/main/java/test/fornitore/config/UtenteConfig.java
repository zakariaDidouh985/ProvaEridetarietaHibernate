package test.fornitore.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.fornitore.model.Fornitore;
import test.fornitore.model.Utente;
import test.fornitore.repository.FornitoreRepo;
import test.fornitore.repository.UtenteRepo;

import java.util.List;



@Configuration
public class UtenteConfig {

    @Bean(name = "utenteConfiguration")
    public CommandLineRunner commandLineRunner(UtenteRepo utenteRepo, FornitoreRepo fornitoreRepo){
        return args -> {
            if(utenteRepo.findAll().isEmpty()){
                Utente utenteAdmin = Utente.builder().email("admin@dst.it").nome("Theboss").cognome("Admin").build();;
                Utente utenteTeamLeader = Utente.builder().email("teamleader@dst.it").nome("Mario").cognome("Pontillo").build();
                Fornitore utenteFornitore = Fornitore.builder().email("fornitore@dst.it").nome("Mario").cognome("Pontillo").indirizzo("SFVS").partitaIva("SDFDS").build();
                Fornitore utenteFornitore2 = Fornitore.builder().email("fouore@dst.it").nome("Mario").cognome("Pontillo").indirizzo("SFVS").partitaIva("SDFDS").build();
                Fornitore utenteFornitore3 = Fornitore.builder().indirizzo("SFVS").partitaIva("SDFDS").build();
                utenteRepo.saveAll(List.of(utenteAdmin, utenteTeamLeader ));
                fornitoreRepo.saveAll(List.of(utenteFornitore2, utenteFornitore, utenteFornitore3));

            }
        };
    }

}
