package com.itis.repository;

import com.itis.model.User;
import com.itis.model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alt
 */
@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
    List<UserNotification> findByUser(User user);
    List<UserNotification> findByUserAndIsRead(User user, Boolean isRead);
}
