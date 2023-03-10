package ru.skypro.homework.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.UserProfile;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    Optional<UserProfile> findByEmail(String email);
    Optional<UserProfile> findById(Long id);

    Optional<UserProfile> deleteById(Long id);
}
