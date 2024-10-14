package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableUsers;

import java.util.List;

public interface UserService {
    /**
     * Сохраняет пользователя
     * @param user передаваемый пользователя
     * @return сохраненный пользователь
     */
    TableUsers saveUser(TableUsers user);

    /**
     * Возвращает список всех имеющихся поьлзователей
     * @return список пользователей
     */
    List<TableUsers> getTableUsersList();

    /**
     * Обновляет переданного пользователя
     * @param user передаваемый пользователь
     * @return обновлелнный пользователь
     */
    TableUsers updateUser(TableUsers user);

    /**
     * Удаляет пользователя
     * @param user удаляемый пользователь
     */
    void deleteUser(TableUsers user);

    /**
     * Поиск пользователя по идентификатору
     * @param id id пользователя
     * @return найденный пользователь
     */
    TableUsers getUserById(int id);

    /**
     * Поиск пользователя по имени
     * @param name имя пользователя
     * @return найденный пользователь
     */
    TableUsers getUserByName(String name);
}
