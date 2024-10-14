package com.bravepaws.ideabrowser_v2.controllers.helper;

import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import com.bravepaws.ideabrowser_v2.tables.TableUsers;

import java.io.Serializable;

// Вспомогательный класс, содержащий информацию о содержимом строки таблицы идей,
// выводящейся на главную страницу
public class TableLine implements Serializable {
    public final TableUsers l_user;
    public final TableThemes l_theme;
    public final TableIdeas l_idea;

    public TableLine(TableUsers user, TableThemes theme, TableIdeas idea) {
        this.l_user = user;
        this.l_theme = theme;
        this.l_idea = idea;
    }
}
