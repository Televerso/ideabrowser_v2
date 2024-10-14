package com.bravepaws.ideabrowser_v2.repositories;

import com.bravepaws.ideabrowser_v2.tables.TableUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<TableUsers, Integer> {
    /**
     * Поиск пользователя по имени
     * @param username имя пользователя
     * @return найденный пользователь
     */
    TableUsers findByUserName(String username);

    /**
     * Поиск по идентификатору пользователя
     * @param id id пользователя
     * @return найденный пользователь
     */
    TableUsers findByUserId(Integer id);
}
