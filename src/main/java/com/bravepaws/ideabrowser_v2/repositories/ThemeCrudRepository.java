package com.bravepaws.ideabrowser_v2.repositories;

import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeCrudRepository extends CrudRepository<TableThemes, Integer> {
    /**
     * Поиск тем по их названию
     * @param name название темы
     * @return список найденных тем
     */
    List<TableThemes> findByThemeName(String name);

    /**
     * Поиск по направлению темы
     * @param fieldOfAction направление темы
     * @return список найденных тем
     */
    List<TableThemes> findByThemeFieldOA(String fieldOfAction);

    /**
     * Поиск по тегу темы
     * @param tag тег темы
     * @return список найденных тем
     */
    List<TableThemes> findByThemeTag(String tag);

    /**
     * Посик по идентификатору темы
     * @param id id темы
     * @return найденная тема
     */
    TableThemes findByThemeId(Integer id);

}
