package com.itis.repository;

import com.itis.model.Decree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author r.khakov
 */
@Repository
public interface DecreesRepository extends JpaRepository<Decree, Long> {
    Decree getDecreeByStartsYear(Integer startsYear);
}
