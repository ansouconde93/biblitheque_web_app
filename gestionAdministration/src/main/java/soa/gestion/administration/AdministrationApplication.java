package soa.gestion.administration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.entities.Roles;
import soa.gestion.administration.services.servicesInterface.AutorisationsService;
import soa.gestion.administration.services.servicesInterface.RolesService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdministrationApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AdministrationApplication.class, args);
        RolesService rolesService = context.getBean(RolesService.class);
        AutorisationsService autorisationsService = context.getBean(AutorisationsService.class);

        autorisationsService.save(new Autorisations(null, "read", false));
        autorisationsService.save(new Autorisations(null, "create", false));
        autorisationsService.save(new Autorisations(null, "update", false));
        autorisationsService.save(new Autorisations(null, "delete", false));
        autorisationsService.save(new Autorisations(null, "view", false));
        autorisationsService.save(new Autorisations(null, "audite", false));
        autorisationsService.save(new Autorisations(null, "read_catalogue", false));
        autorisationsService.save(new Autorisations(null, "update_db", false));
        autorisationsService.save(new Autorisations(null, "create_db", false));
        autorisationsService.save(new Autorisations(null, "drop", false));
        autorisationsService.save(new Autorisations(null, "view_log", false));

        Roles role1 = new Roles();
        role1.setId(null);
        role1.setSusppendu(false); role1.setRole("root");
        List<Autorisations> autorisationsList = new ArrayList<>();
        autorisationsList.addAll(autorisationsService.getAll());
        role1.setAutorisations(autorisationsList);
        rolesService.save(role1);

    }

}
