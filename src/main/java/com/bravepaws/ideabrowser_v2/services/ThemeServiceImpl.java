package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.repositories.ThemeCrudRepository;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeCrudRepository themeCrudRepository;

    @Transactional
    public TableThemes saveTheme(TableThemes theme) {
        return themeCrudRepository.save(theme);
    }

    @Transactional
    public List<TableThemes> getTableThemesList() {
        return (List<TableThemes>) themeCrudRepository.findAll();
    }

    @Transactional
    public TableThemes updateTheme(TableThemes theme) {
        // TODO обновление темы
        return themeCrudRepository.save(theme);
    }

    @Transactional
    public void deleteTheme(TableThemes theme) {
        // TODO удаление темы
        themeCrudRepository.delete(theme);
    }

    @Transactional
    public TableThemes getThemeById(int id) {
        return themeCrudRepository.findByThemeId(id);
    }
}
