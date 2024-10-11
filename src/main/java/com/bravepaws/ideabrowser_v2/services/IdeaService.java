package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IdeaService {

    TableIdeas saveTableIdea(TableIdeas tableIdea);

    List<TableIdeas> getTableIdeasList();

    TableIdeas updateTableIdea(TableIdeas tableIdea);

    void deleteTableIdea(TableIdeas tableIdea);
}
