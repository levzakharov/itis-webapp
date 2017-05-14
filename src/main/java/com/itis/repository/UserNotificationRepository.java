package com.itis.repository;

import com.itis.model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alt
 */
@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
}
