package com.itis.service;

import com.itis.form.RequestCreationForm;
import com.itis.model.Request;

import java.util.List;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
public interface RequestService {
    List<Request> getPendingRequests();

    List<Request> getUserRequests();

    void createRequest(RequestCreationForm form);

    void acceptRequest(Long id);

    void declineRequest(Long id);

}
