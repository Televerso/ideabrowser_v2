package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.repositories.UTICrudRepository;
import com.bravepaws.ideabrowser_v2.tables.TableUsersToIdeas;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtiServiceImpl implements UtiService {
    @Autowired
    private UTICrudRepository utiCrudRepository;

    @Transactional
    public TableUsersToIdeas saveUti(TableUsersToIdeas usersToIdeas) {
        return utiCrudRepository.save(usersToIdeas);
    }

    @Transactional
    public List<TableUsersToIdeas> getTableUti() {
        return (List<TableUsersToIdeas>) utiCrudRepository.findAll();
    }

    @Transactional
    public TableUsersToIdeas updateUti(TableUsersToIdeas tableIdea) {
        return utiCrudRepository.save(tableIdea);
    }

    @Transactional
    public void deleteUti(TableUsersToIdeas usersToIdeas) {
        utiCrudRepository.delete(usersToIdeas);
    }

    @Transactional
    public Optional<TableUsersToIdeas> getUtiById(int id) {return utiCrudRepository.findById(id);}

    @Override
    public List<TableUsersToIdeas> getUtiByUserId(int userId) {
        return utiCrudRepository.findByUserid(userId);
    }

    @Override
    public List<TableUsersToIdeas> getUtiByIdeaId(int ideaId) {
        return utiCrudRepository.findByIdeaid(ideaId);
    }
}
