package org.sid.jee_exam_backend;

import org.sid.jee_exam_backend.entities.*;
import org.sid.jee_exam_backend.repositories.*;
import org.sid.jee_exam_backend.entities.*;
import org.sid.jee_exam_backend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JeeExamBackendApplication implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final CreditPersonnelRepository creditPersonnelRepository;
    private final CreditImmobilierRepository creditImmobilierRepository;
    private final CreditProfessionnelRepository creditProfessionnelRepository;
    private final RemboursementRepository remboursementRepository;

    public JeeExamBackendApplication(ClientRepository clientRepository,
                                     CreditRepository creditRepository,
                                     CreditPersonnelRepository creditPersonnelRepository,
                                     CreditImmobilierRepository creditImmobilierRepository,
                                     CreditProfessionnelRepository creditProfessionnelRepository,
                                     RemboursementRepository remboursementRepository) {
        this.clientRepository = clientRepository;
        this.creditRepository = creditRepository;
        this.creditPersonnelRepository = creditPersonnelRepository;
        this.creditImmobilierRepository = creditImmobilierRepository;
        this.creditProfessionnelRepository = creditProfessionnelRepository;
        this.remboursementRepository = remboursementRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JeeExamBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client client1 = clientRepository.save(Client.builder()
                .nom("yassine")
                .email("yassine@mail.com")
                .build());

        Client client2 = clientRepository.save(Client.builder()
                .nom("yahya")
                .email("yahya@mail.com")
                .build());
        Client client3 = clientRepository.save(Client.builder()
                .nom("fatima-azzahra")
                .email("fatimaazzahra@mail.com")
                .build());

        Client client4 = clientRepository.save(Client.builder()
                .nom("laila")
                .email("laila@mail.com")
                .build());

        CreditPersonnel cp = CreditPersonnel.builder()
                .dateDemande(new Date())
                .statut("En cours")
                .montant(50000)
                .dureeRemboursement(24)
                .tauxInteret(5.5)
                .motif("Achat Voiture")
                .client(client1)
                .build();
        creditPersonnelRepository.save(cp);

        CreditImmobilier ci = CreditImmobilier.builder()
                .dateDemande(new Date())
                .statut("Accepté")
                .dateAcception(new Date())
                .montant(300000)
                .dureeRemboursement(120)
                .tauxInteret(3.2)
                .typeBien("Appartement")
                .client(client2)
                .build();
        creditImmobilierRepository.save(ci);

        CreditProfessionnel cpro = CreditProfessionnel.builder()
                .dateDemande(new Date())
                .statut("Rejeté")
                .montant(150000)
                .dureeRemboursement(36)
                .tauxInteret(6.0)
                .motif("Investissement matériel")
                .raisonSociale("SARL TechPlus")
                .client(client2)
                .build();
        creditProfessionnelRepository.save(cpro);

        Remboursement r1 = Remboursement.builder()
                .date(new Date())
                .montant(2200)
                .type("Mensualité")
                .credit(cp)
                .build();
        remboursementRepository.save(r1);

        Remboursement r2 = Remboursement.builder()
                .date(new Date())
                .montant(3000)
                .type("Remboursement anticipé")
                .credit(ci)
                .build();
        remboursementRepository.save(r2);
    }
}
