package com.itis.repository;

import com.itis.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Repository
public interface GroupRepository extends JpaRepository<UserGroup, Long> {
}