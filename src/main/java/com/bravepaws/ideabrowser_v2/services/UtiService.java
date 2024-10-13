package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableUsersToIdeas;

import java.util.List;
import java.util.Optional;

public interface UtiService {
    TableUsersToIdeas saveUti(TableUsersToIdeas usersToIdeas);

    List<TableUsersToIdeas> getTableUti();

    TableUsersToIdeas updateUti(TableUsersToIdeas usersToIdeas);

    void deleteUti(TableUsersToIdeas usersToIdeas);

    Optional<TableUsersToIdeas> getUtiById(int id);

    List<TableUsersToIdeas> getUtiByUserId(int userId);

    List<TableUsersToIdeas> getUtiByIdeaId(int ideaId);
}
