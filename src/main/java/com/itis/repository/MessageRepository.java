package com.itis.repository;

import com.itis.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByFromUserAndToUser(final String from, final String to);

    @Query(value = "SELECT DISTINCT ON (from_user)\n" +
            "  id,\n" +
            "  content,\n" +
            "  from_user,\n" +
            "  to_user,\n" +
            "  unread,\n" +
            "  timestamp\n" +
            "FROM public.message\n" +
            "WHERE to_user = ?1\n" +
            "ORDER BY from_user, timestamp DESC", nativeQuery = true)
    List<Message> getPreview(final String user);
}
