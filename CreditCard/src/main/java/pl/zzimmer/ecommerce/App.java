package pl.zzimmer.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.zzimmer.ecommerce.catalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        System.out.println("Here we go");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyCatalog(){
        var catalog = new ProductCatalog();
        catalog.addProduct("Lego set 8298", "Nice one");
        catalog.addProduct("cobi bricks", "Nice one");

        return catalog;
    }
}
