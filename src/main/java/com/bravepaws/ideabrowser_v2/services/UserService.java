package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.tables.TableUsers;

import java.util.List;

public interface UserService {
    TableUsers saveUser(TableUsers user);

    List<TableUsers> getTableUsersList();

    TableUsers updateUser(TableUsers user);

    void deleteUser(TableUsers user);

    TableUsers getUserById(int id);
}
