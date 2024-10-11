package com.bravepaws.ideabrowser_v2;

import com.bravepaws.ideabrowser_v2.repositories.IdeaCrudRepository;
import com.bravepaws.ideabrowser_v2.repositories.IdeaCrudRepositoryImpl;
import com.bravepaws.ideabrowser_v2.services.IdeaService;
import com.bravepaws.ideabrowser_v2.services.IdeaServiceImpl;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class IdeaBrowserV2Application {

    public static void main(String[] args) {
        SpringApplication.run(IdeaBrowserV2Application.class, args);
        TableIdeas tableIdeas = new TableIdeas();
        System.out.println(tableIdeas.toString());
    }

}
