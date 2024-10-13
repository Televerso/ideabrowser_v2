package com.bravepaws.ideabrowser_v2.repositories;


import com.bravepaws.ideabrowser_v2.tables.TableUsersToIdeas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UTICrudRepository extends CrudRepository<TableUsersToIdeas, Integer>
{
    TableUsersToIdeas findByUtiId(Integer id);

    List<TableUsersToIdeas> findByIdeaid(int ideaId);

    List<TableUsersToIdeas> findByUserid(int userId);
}
