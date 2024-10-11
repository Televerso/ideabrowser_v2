package com.bravepaws.ideabrowser_v2.services;

import com.bravepaws.ideabrowser_v2.repositories.UserCrudRepository;
import com.bravepaws.ideabrowser_v2.tables.TableIdeas;
import com.bravepaws.ideabrowser_v2.tables.TableUsers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Transactional
    public TableUsers saveUser(TableUsers user) {
        return userCrudRepository.save(user);
    }

    @Transactional
    public List<TableUsers> getTableUsersList() {
        return (List<TableUsers>) userCrudRepository.findAll();
    }

    @Transactional
    public TableUsers updateUser(TableUsers user) {
        return userCrudRepository.save(user);
    }

    @Transactional
    public void deleteUser(TableUsers user) {
        userCrudRepository.delete(user);
    }
}
