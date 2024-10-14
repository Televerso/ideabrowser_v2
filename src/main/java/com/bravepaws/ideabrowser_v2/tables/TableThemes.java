package com.bravepaws.ideabrowser_v2.tables;

import jakarta.persistence.*;

// Таблица тем
@Entity
@Table(name = "themes")
public class TableThemes implements BaseTable {
    // Поля таблицы
    private int themeid;
    private String themeName;
    private String themeFieldOA;
    private String themeTag;

    // Конструктор по умолчанию
    public TableThemes() {
    }

    // Простой конструктор
    public TableThemes(String themeName) {
        this.themeName = themeName;
        this.themeFieldOA = themeName;
        this.themeTag = themeName;
    }

    // Сложный конструктор
    public TableThemes(String themeName, String themeFieldOA, String themeTag) {
        this.themeName = themeName;
        this.themeFieldOA = themeFieldOA;
        this.themeTag = themeTag;
    }

    // Дальше идут сеттеры и геттеры для полей таблицы
    // Поле id генерируется, последовательность themes_seq содержится в базе данных
    @Id
    @Column(name = "THEMEID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "THEME_ID_GEN")
    @SequenceGenerator(name = "THEME_ID_GEN", sequenceName = "themes_seq", allocationSize = 1)
    public int getThemeId() {
        return themeid;
    }

    public void setThemeId(int themeid) {
        this.themeid = themeid;
    }

    @Basic
    @Column(name = "THEME NAME")
    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Basic
    @Column(name = "FIELD OF ACTION")
    public String getThemeFieldOA() {
        return themeFieldOA;
    }

    public void setThemeFieldOA(String themeFieldOA) {
        this.themeFieldOA = themeFieldOA;
    }

    @Basic
    @Column(name = "TAGS")
    public String getThemeTag() {
        return themeTag;
    }

    public void setThemeTag(String themeTag) {
        this.themeTag = themeTag;
    }
}
