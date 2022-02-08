package soa.gestion.gateway;

import com.ctc.wstx.dtd.ModelNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);

    }
/*
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }*/
/*
    @Bean
    RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/autorisations/**").uri("lb://gestion-administration"))
                .route(r->r.path("/roles/**").uri("lb://gestion-administration"))
                .route(r->r.path("/livre/**").uri("lb://gestion-livre"))
                .route(r->r.path("/membre/**").uri("lb://gestion-membre"))
                .build();

    }
*/

    /*
           configuration dynamique
    */

    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }



   /* @Bean
    public GlobalFilter globalFilter() {
        return (exchange, chain) -> {

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Second Global filter");
            }));
        };
    }*/


}
