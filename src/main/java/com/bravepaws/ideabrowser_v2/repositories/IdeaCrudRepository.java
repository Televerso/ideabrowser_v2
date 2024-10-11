package com.bravepaws.ideabrowser_v2.repositories;

import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaCrudRepository extends CrudRepository<TableIdeas, Integer>
{
    TableIdeas findByIdeaId(Integer id);

    List<TableIdeas> findByIdeaName(String Name);

    List<TableIdeas> findByCategory(String Category);
}
