package com.itis.repository;

import com.itis.model.Request;
import com.itis.model.User;
import com.itis.model.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByStatusOrderByDateDesc(RequestStatus status);

    List<Request> findByUserOrderByDateDesc(User user);

    @Query("UPDATE Request r SET r.status = 'ACCEPTED' WHERE r.id = :id")
    @Modifying
    void accept(@Param("id") Long id);

    @Query("UPDATE Request r SET r.status = 'DECLINED' WHERE r.id = :id")
    @Modifying
    void decline(@Param("id") Long id);

    List<Request> findByStatusOrStatus(RequestStatus firstStatus, RequestStatus secondStatus);
}
