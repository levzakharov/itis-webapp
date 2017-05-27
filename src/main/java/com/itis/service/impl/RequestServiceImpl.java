package com.itis.service.impl;

import com.itis.form.RequestCreationForm;
import com.itis.model.Request;
import com.itis.model.enums.RequestStatus;
import com.itis.repository.RequestRepository;
import com.itis.security.SecurityUtils;
import com.itis.service.RequestService;
import com.itis.utils.DocumentGenerator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
@Service
public class RequestServiceImpl implements RequestService {

    private static final Logger LOGGER = Logger.getLogger(RequestServiceImpl.class);

    @Lazy
    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Request> getPendingRequests() {
        try {
            return requestRepository.findByStatus(RequestStatus.PENDING);
        } catch (Exception e) {
            LOGGER.error("No requests found in the database", e);
            return null;
        }
    }

    @Override
    public List<Request> getCurrentUserRequests() {
        try {
            return requestRepository.findByUserOrderByDateDesc(SecurityUtils.getCurrentUser());
        } catch (Exception e) {
            LOGGER.error("No requests found in the database", e);
            return null;
        }
    }

    @Override
    public void createRequest(RequestCreationForm form) {
        Request request = new Request();
        request.setDate(new Date().getTime());
        request.setStatus(RequestStatus.PENDING);
        request.setUser(SecurityUtils.getCurrentUser());
        request.setAmount(form.getAmount());
        requestRepository.save(request);
    }

    @Transactional
    @Override
    public void acceptRequest(Long id) {
        requestRepository.accept(id);
    }

    @Transactional
    @Override
    public void declineRequest(Long id) {
        requestRepository.decline(id);
    }

    @Override
    public String generateCertificate(String fullName) {
        try {
            return DocumentGenerator.generateDocument(fullName);
        } catch (IOException e) {
            LOGGER.error("problems with generating file", e);
            return null;
        }
    }
}
