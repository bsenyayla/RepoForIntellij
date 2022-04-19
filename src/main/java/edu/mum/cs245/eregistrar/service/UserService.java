package edu.mum.cs245.eregistrar.service;

import edu.mum.cs245.eregistrar.model.User;

import java.util.List;

public interface UserService {

    public abstract List<User> getAllUsers();
    public abstract User getUserById(Integer userId);
}
