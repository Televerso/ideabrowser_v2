package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.repositories.IdeaCrudRepository;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaServiceImpl implements IdeaService {
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
        // TODO обновление идей
        return ideaCrudRepository.save(tableIdea);
    }

    @Transactional
    public void deleteTableIdea(TableIdeas tableIdea) {
        // TODO удаление идей
        ideaCrudRepository.delete(tableIdea);
    }

    @Transactional
    public TableIdeas getTableIdeaById(int id) {
        return ideaCrudRepository.findByIdeaId(id);
    }

    @Transactional
    public List<TableIdeas> getIdeasByCustomer(int customer) {
        return ideaCrudRepository.findByCustomer(customer);
    }
}
