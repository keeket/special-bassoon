package springcourse.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springcourse.petclinic.model.Owner;
import springcourse.petclinic.model.Vet;
import springcourse.petclinic.services.OwnerService;
import springcourse.petclinic.services.VetService;

// doordat de klasse een bean is wordt automatisch de run methode aangeroepen wanneer de klasse geinitialisserd wordt
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    // service injectie door de spring container ipv constructor instantiering daarnaast is dit ook flexibeler omdat de interface
    // wordt gebruikt en geen concrete klasse
    // Ondanks dat de services in een andere map staan komt de packagenaam in beide projecten overeen en daardoor vindbaar voor spring
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    // argumenten van de commandline worden in feite niet gebruikt, dit is enkel een manier om bij opstarten automstisch
    // de code uit te voeren in de body
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Micahel");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenane");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("owners loaded..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("vets loaded..");
    }
}
