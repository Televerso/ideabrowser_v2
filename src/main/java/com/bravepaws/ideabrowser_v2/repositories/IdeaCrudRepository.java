package com.bravepaws.ideabrowser_v2.repositories;

import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Репозиторий для работы с идеями
@Repository
public interface IdeaCrudRepository extends CrudRepository<TableIdeas, Integer> {
    /**
     * Поиск идей по названию
     * @param Name название идеи
     * @return список найденных идей
     */
    List<TableIdeas> findByIdeaName(String Name);

    List<TableIdeas> findByCategory(String Category);

    TableIdeas findByIdeaId(Integer id);

    List<TableIdeas> findByCustomer(Integer id);
}
