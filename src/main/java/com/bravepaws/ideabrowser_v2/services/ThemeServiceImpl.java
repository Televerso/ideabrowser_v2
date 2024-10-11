package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.repositories.ThemeCrudRepository;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    private ThemeCrudRepository themeCrudRepository;
    @Override
    public TableThemes saveTheme(TableThemes theme) {
        return themeCrudRepository.save(theme);
    }

    @Override
    public List<TableThemes> getTableThemesList() {
        return (List<TableThemes>) themeCrudRepository.findAll();
    }

    @Override
    public TableThemes updateTheme(TableThemes theme) {
        return themeCrudRepository.save(theme);
    }

    @Override
    public void deleteTheme(TableThemes theme) {
        themeCrudRepository.delete(theme);
    }
}
