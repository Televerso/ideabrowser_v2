package com.bravepaws.ideabrowser_v2.repositories;

import com.bravepaws.ideabrowser_v2.tables.TableUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCrudRepository extends CrudRepository<TableUsers, Integer> {
    List<TableUsers> findByUserName(String username);

    TableUsers findByUserId(Integer userId);

}
