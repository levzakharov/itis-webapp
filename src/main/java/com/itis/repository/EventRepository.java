package com.itis.repository;

import com.itis.model.Event;
import com.itis.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByDay(DayOfWeek day);

    List<Event> findByUserGroup(UserGroup userGroup);

    List<Event> findByUserGroupAndDay(UserGroup userGroup, DayOfWeek day);

}
