package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableIdeas;

import java.util.List;

public interface IdeaService {

    /**
     * Сохраняет идею
     * @param tableIdea передаваемая идея
     * @return сохраненная идея
     */
    TableIdeas saveTableIdea(TableIdeas tableIdea);

    /**
     * Возвращает список всех имеющихся идей
     * @return список идей
     */
    List<TableIdeas> getTableIdeasList();

    /**
     * Обновляет переданную идею
     * @param tableIdea передаваемая идея
     * @return обновлелнная идея
     */
    TableIdeas updateTableIdea(TableIdeas tableIdea);

    /**
     * Удаляет идею
     * @param tableIdea удаляемая идея
     */
    void deleteTableIdea(TableIdeas tableIdea);

    /**
     * Поиск идеи по идентификатору
     * @param id id идеи
     * @return найденная идея
     */
    TableIdeas getTableIdeaById(int id);

    /**
     * Поиск идей по пользователям
     * @param customer пользователь - владелец идеи
     * @return список найденных идей
     */
    List<TableIdeas> getIdeasByCustomer(int customer);
}
