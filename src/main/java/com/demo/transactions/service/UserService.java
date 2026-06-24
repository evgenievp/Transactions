package com.demo.transactions.service;

import com.demo.transactions.dtos.UserDto;
import com.demo.transactions.entities.User;
import com.demo.transactions.repo.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo repo;


    public UserService(UserRepo repo) {
        this.repo = repo;
    }


    public Optional<UserDto> findByEmail(String email) {
        Optional<User> user = this.repo.findByEmail(email);
        if (user.isPresent()) {
            return Optional.ofNullable(mapUserToDto(user.get()));
        }
        return Optional.empty();
    }

    public void createUser(UserDto user) {
        this.repo.save(mapDtoToUser(user));
    }

    public UserDto mapUserToDto(User user) {
        return new UserDto(
                user.getUsername(),
                user.getEmail()
        );
    }

    public User mapDtoToUser(UserDto user) {
        return new User(
                user.getUsername(),
                user.getEmail()
        );
    }

    public UserDto findById(long id) {
        Optional<User> res = repo.findById(id);
        if (res.isEmpty()) {
            throw new EntityNotFoundException("no such user");
        }
        return mapUserToDto(res.get());
    }


}
