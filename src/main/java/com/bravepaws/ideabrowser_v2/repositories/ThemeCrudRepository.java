package com.bravepaws.ideabrowser_v2.repositories;

import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeCrudRepository extends CrudRepository<TableThemes, Integer> {
    List<TableThemes> findByThemeName(String name);

    TableThemes findByThemeId(Integer id);

    List<TableThemes> findByThemeFieldOA(String fieldOfAction);

    List<TableThemes> findByThemeTag(String tag);
}
