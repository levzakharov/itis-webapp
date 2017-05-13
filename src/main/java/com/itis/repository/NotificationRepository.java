package com.itis.repository;

import com.itis.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alt
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
