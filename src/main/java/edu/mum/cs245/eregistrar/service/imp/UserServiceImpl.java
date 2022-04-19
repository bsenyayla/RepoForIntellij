package edu.mum.cs245.eregistrar.service.imp;

import edu.mum.cs245.eregistrar.model.User;
import edu.mum.cs245.eregistrar.repository.UserRepository;
import edu.mum.cs245.eregistrar.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
