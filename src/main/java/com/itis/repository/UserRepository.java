package com.itis.repository;

import com.itis.model.User;
import com.itis.model.UserGroup;
import com.itis.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query("UPDATE User u SET u.enabled = false WHERE u.id = :id")
    @Modifying
    void ban(@Param("id") Long id);

    @Query("UPDATE User u SET u.enabled = true WHERE u.id = :id")
    @Modifying
    void unban(@Param("id") Long id);

}