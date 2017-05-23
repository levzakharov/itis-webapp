package com.itis.repository;

import com.itis.model.Event;
import com.itis.model.User;
import com.itis.model.UserGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

//    @Query("select e from Event e inner join e.users u where u=:user")
//    List<Event> findByUser(User user);

//    List<Event> findByDateGreaterThanAndDateLessThan(Long startDate, Long endDate);
}
