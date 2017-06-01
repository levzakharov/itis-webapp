package com.itis.repository;

import com.itis.model.User;
import com.itis.model.UserGroup;
import com.itis.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByUserGroup(UserGroup userGroup);

    @Query("SELECT u FROM User u WHERE :role not in elements(u.roles)")
    List<User> findAllNotContainingRole(@Param("role") Role role);
}