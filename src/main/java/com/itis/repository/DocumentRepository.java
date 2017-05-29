package com.itis.repository;

import com.itis.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author softi on 23.05.2017.
 */
public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByUserId(long userId);

}