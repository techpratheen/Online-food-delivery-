package com.tech.pro.services;

import com.tech.pro.entity.Users;
import com.tech.pro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public Optional<Users> getUser(Long id) {
        return userRepository.findById(id);
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users addOrUpdateUser(Users users) {
        users.getUserAddresses().forEach(userAddress -> userAddress.setUsers(users));
        users.getUserContacts().forEach(userContact -> userContact.setUsers(users));
        return userRepository.save(users);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Users getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
