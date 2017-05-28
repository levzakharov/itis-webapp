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
    private final DocumentGenerator documentGenerator;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository, DocumentGenerator documentGenerator) {
        this.requestRepository = requestRepository;
        this.documentGenerator = documentGenerator;
    }

    @Override
    public List<Request> getPendingRequests() {
        try {
            return requestRepository.findByStatusOrderByDateDesc(RequestStatus.PENDING);
        } catch (Exception e) {
            LOGGER.error("No requests found in the database", e);
            return null;
        }
    }

    @Override
    public List<Request> getAcceptedRequests() {
        try {
            return requestRepository.findByStatusOrderByDateDesc(RequestStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("No requests found in the database", e);
            return null;
        }
    }

    @Override
    public List<Request> getDeclinedRequests() {
        try {
            return requestRepository.findByStatusOrderByDateDesc(RequestStatus.DECLINED);
        } catch (Exception e) {
            LOGGER.error("No requests found in the database", e);
            return null;
        }
    }

    @Override
    public List<Request> getProcessedRequests() {
        try {
            return requestRepository.findByStatusOrStatusOrderByDateDesc(RequestStatus.ACCEPTED, RequestStatus.DECLINED);
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
    public String generateCertificate(Long requestId) {
        try {
            return documentGenerator.generateDocument(requestRepository.findOne(requestId).getUser());
        } catch (IOException e) {
            LOGGER.error("problems with generating file", e);
            return null;
        }
    }
}