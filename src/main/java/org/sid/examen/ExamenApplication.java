package org.sid.examen;

import org.sid.examen.entities.*;
import org.sid.examen.enums.StatutCredit;
import org.sid.examen.enums.TypeImmobilier;
import org.sid.examen.enums.TypeRemboursement;
import org.sid.examen.repositories.ClientRepository;
import org.sid.examen.repositories.CreditRepository;
import org.sid.examen.repositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class ExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            CreditRepository creditRepository,
                            RemboursementRepository remboursementRepository) {
        return args -> {
            // Création de quelques clients
            Stream.of("Salma", "Omar", "Karim").forEach(nom -> {
                Client client = new Client();
                client.setNom(nom);
                client.setEmail(nom.toLowerCase() + "@examen.com");
                clientRepository.save(client);
            });

            Random random = new Random();

            // Création de crédits pour chaque client
            clientRepository.findAll().forEach(client -> {
                // Crédit Immobilier
                CreditImmobilier ci = new CreditImmobilier();
                ci.setClient(client);
                ci.setDateDemande(new Date());
                ci.setDateAcception(new Date());
                ci.setStatut(StatutCredit.ACCEPTE);
                ci.setMontant(800000 + random.nextInt(200000));
                ci.setTauxInteret(3.2);
                ci.setDureeRemboursement(240); // 20 ans
                ci.setTypeBien(TypeImmobilier.APPARTEMENT);
                ci.setRemboursements(new ArrayList<>());
                creditRepository.save(ci);

                // Crédit Personnel
                CreditPersonnel cp = new CreditPersonnel();
                cp.setClient(client);
                cp.setDateDemande(new Date());
                cp.setDateAcception(new Date());
                cp.setStatut(StatutCredit.EN_ATTENTE);
                cp.setMontant(100000 + random.nextInt(50000));
                cp.setTauxInteret(5.5);
                cp.setDureeRemboursement(60); // 5 ans
                cp.setMotif("Achat voiture");
                cp.setRemboursements(new ArrayList<>());
                creditRepository.save(cp);

                // Crédit Professionnel
                CreditProfessionnel cpro = new CreditProfessionnel();
                cpro.setClient(client);
                cpro.setDateDemande(new Date());
                cpro.setDateAcception(new Date());
                cpro.setStatut(StatutCredit.REJETE);
                cpro.setMontant(500000);
                cpro.setTauxInteret(4.0);
                cpro.setDureeRemboursement(120); // 10 ans
                cpro.setMotif("Création entreprise");
                cpro.setRaisonSociale("Tech & Co");
                cpro.setRemboursements(new ArrayList<>());
                creditRepository.save(cpro);
            });

            // Ajout d'un remboursement au premier crédit uniquement
            creditRepository.findAll().stream().findFirst().ifPresent(credit -> {
                Remboursement remboursement = new Remboursement();
                remboursement.setDate(new Date());
                remboursement.setMontant(credit.getMontant() / credit.getDureeRemboursement());
                remboursement.setType(TypeRemboursement.MENSUALITE);
                remboursement.setCredit(credit); // association manuelle

                // Ajouter le remboursement dans la liste (bidirectionnelle)
                if (credit.getRemboursements() == null) {
                    credit.setRemboursements(new ArrayList<>());
                }
                credit.getRemboursements().add(remboursement);

                // Sauvegarder d'abord le remboursement (si cascade n'est pas activé dans l'entité)
                remboursementRepository.save(remboursement);

                // Ou bien juste : creditRepository.save(credit); si cascade = CascadeType.PERSIST
            });

        };
    }
}
