package com.travelagency.tirana.service.Impl.UserImpl;


import com.travelagency.tirana.model.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    long save(SaveUserRequest request);
    List<User> getAll();
    Optional<User> getById(long user);
    void delete(long userId);
}
