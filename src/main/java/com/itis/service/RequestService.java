package com.itis.service;

import com.itis.form.RequestCreationForm;
import com.itis.model.Request;

import java.util.List;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
public interface RequestService {
    List<Request> getPendingRequests();

    List<Request> getAcceptedRequests();

    List<Request> getDeclinedRequests();

    List<Request> getCurrentUserRequests();

    void createRequest(RequestCreationForm form);

    void acceptRequest(Long id);

    void declineRequest(Long id);

    String generateCertificate(String fullName);

}