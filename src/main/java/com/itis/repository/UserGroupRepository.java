package com.itis.repository;

import com.itis.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    List<UserGroup> findByStartYear(Integer startYear);

    UserGroup findByNumber(String number);

}