package com.bravepaws.ideabrowser_v2.controllers.helper;

import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableThemes;
import com.bravepaws.ideabrowser_v2.tables.TableUsers;

import java.io.Serializable;

public class TableLine implements Serializable {
    public TableUsers l_user;
    public TableThemes l_theme;
    public TableIdeas l_idea;
    public TableLine(TableUsers user, TableThemes theme, TableIdeas idea)
    {
        this.l_user = user;
        this.l_theme = theme;
        this.l_idea = idea;
    }
    public TableUsers getL_user() { return l_user; }
    public TableThemes getL_theme() { return l_theme; }
    public TableIdeas getL_idea() { return l_idea; }
    public void setL_user(TableUsers l_user) { this.l_user = l_user; }
    public void setL_theme(TableThemes l_theme) { this.l_theme = l_theme; }
    public void setIdea(TableIdeas idea) { this.l_idea = idea; }
}
