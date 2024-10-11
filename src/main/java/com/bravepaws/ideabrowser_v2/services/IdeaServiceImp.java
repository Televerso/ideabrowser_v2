package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.repositories.IdeaCrudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaServiceImp implements IdeaService{
    @Autowired
    private IdeaCrudRepository ideaCrudRepository;

    @Transactional
    public TableIdeas saveTableIdea(TableIdeas tableIdea) {
        return ideaCrudRepository.save(tableIdea);
    }

    @Transactional
    public List<TableIdeas> getTableIdeasList() {
        return (List<TableIdeas>) ideaCrudRepository.findAll();
    }

    @Transactional
    public TableIdeas updateTableIdea(TableIdeas tableIdea) {
        return ideaCrudRepository.save(tableIdea);
    }

    @Transactional
    public void deleteTableIdea(TableIdeas tableIdea) {
        ideaCrudRepository.delete(tableIdea);
    }
}
