package com.itis.service.impl;

import com.itis.model.User;
import com.itis.repository.DecreesRepository;
import com.itis.service.DecreeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author r.khakov
 */
public class DecreeServiceImpl implements DecreeService {
    private final DecreesRepository decreesRepository;

    @Autowired
    public DecreeServiceImpl(DecreesRepository decreesRepository) {
        this.decreesRepository = decreesRepository;
    }

    @Override
    public String getDecreeTextByUser(User user) {
        return decreesRepository.getDecreeByStartsYear(
                user.getUserGroup().getStartYear()).getText();
    }
}
