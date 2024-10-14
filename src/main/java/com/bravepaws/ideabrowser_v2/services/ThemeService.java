package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThemeService {
    /**
     * Сохраняет тему
     * @param theme передаваемая тема
     * @return сохраненная тема
     */
    TableThemes saveTheme(TableThemes theme);

    /**
     * Возвращает список всех имеющихся тем
     * @return список тем
     */
    List<TableThemes> getTableThemesList();

    /**
     * Обновляет переданную тему
     * @param theme передаваемая тема
     * @return обновлелнная тема
     */
    TableThemes updateTheme(TableThemes theme);

    /**
     * Удаляет тему
     * @param theme удаляемая тема
     */
    void deleteTheme(TableThemes theme);

    /**
     * Поиск темы по идентификатору
     * @param id id темы
     * @return найденная тема
     */
    TableThemes getThemeById(int id);
}
