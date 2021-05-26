package com.travelagency.tirana.repository;
import com.travelagency.tirana.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM User WHERE id = :id", nativeQuery = true)
    User findOne(long id);

    User findByEmail(String email);
}
