package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {
    TableThemes saveTheme(TableThemes theme);

    List<TableThemes> getTableThemesList();

    TableThemes updateTheme(TableThemes theme);

    void deleteTheme(TableThemes theme);

    TableThemes getThemeById(int id);
}
