package com.bravepaws.ideabrowser_v2;

import com.bravepaws.ideabrowser_v2.repositories.IdeaCrudRepository;
import com.bravepaws.ideabrowser_v2.repositories.ThemeCrudRepository;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class IdeaBrowserV2Application {

    public static void main(String[] args) {
        SpringApplication.run(IdeaBrowserV2Application.class, args);
        TableIdeas tableIdeas = new TableIdeas();
        System.out.println(tableIdeas.toString());
    }

    @Bean
    public CommandLineRunner demo(@Qualifier("ideaCrudRepository") IdeaCrudRepository repository, ThemeCrudRepository themeCrudRepository) {
        return (args) -> {
            // save a few ideas
            TableIdeas exIdea = new TableIdeas("Idea1", "", "Games", 0,"active", 0);
            repository.save(exIdea);
            repository.save(new TableIdeas("Idea2", 1,"active"));
            repository.save(new TableIdeas("Idea3", 0,"done"));

            // fetch all ideas
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            repository.findAll().forEach(idea -> {
                System.out.print(idea.toString());
            });
            System.out.println("");

            // fetch an individual idea by ID
            Optional<TableIdeas> tableIdea = repository.findById(1);
            System.out.println("Customer found with findById(1L):");
            System.out.println("--------------------------------");
            System.out.println(tableIdea.toString());
            System.out.println("");

            // fetch idea by category name
            System.out.println("Customer found with findByLastName('Bauer'):");
            System.out.println("--------------------------------------------");
            repository.findByCategory("Games").forEach(idea -> {
                System.out.println(idea.toString());
            });
            System.out.println("");
        };
    }

}

