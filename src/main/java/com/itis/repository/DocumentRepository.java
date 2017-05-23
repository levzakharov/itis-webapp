package com.itis.repository;

import com.itis.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by softi on 23.05.2017.
 */
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
