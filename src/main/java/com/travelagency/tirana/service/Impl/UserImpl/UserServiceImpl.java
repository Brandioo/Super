package com.travelagency.tirana.service.Impl.UserImpl;

import com.travelagency.tirana.model.Banner;
import com.travelagency.tirana.model.User;
import com.travelagency.tirana.repository.UserRepository;
import com.travelagency.tirana.service.Impl.BannerImpl.BannerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Override
    public long save(SaveUserRequest request) {
        var dbUser = userRepository.findById(request.getId());
        if (dbUser.isPresent()) {
            dbUser.get().setEmail(request.getEmail());
            dbUser.get().setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
            userRepository.save(dbUser.get());
            return dbUser.get().getId();
        }

        var newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        userRepository.save(newUser);
        return newUser.getId();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(long userId) {
        var dbUser = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        userRepository.delete(dbUser);
    }
}
