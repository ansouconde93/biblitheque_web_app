package soa.gestion.membre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import soa.gestion.membre.entities.AppUsers;
import soa.gestion.membre.modele.UserWithRoles;
import soa.gestion.membre.services.servicesInterface.AppUsersService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class MembreApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(MembreApplication.class, args);
        AppUsersService appUsersService = context.getBean(AppUsersService.class);
        AppUsers appUsers = new AppUsers();
        appUsers.setId(null);
        appUsers.setEmail("root@gmail.com");
        appUsers.setMatricule("GN160021");
        appUsers.setPassword("root");
        appUsers.setNom("root");
        appUsers.setPrenom("root");
        appUsers.setSection(null);
        appUsers.setTelephone("7012365478");

        List<String> rolesName = new ArrayList<>();
        rolesName.add("root");
        rolesName.add("admin");
        rolesName.add("etudiant");
        rolesName.add("professeur");
        rolesName.add("scolarite");
        rolesName.add("chef");

        appUsersService.save(new UserWithRoles(appUsers, rolesName));

    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {

     return new BCryptPasswordEncoder();
    }
}
