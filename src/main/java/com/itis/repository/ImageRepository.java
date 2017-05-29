package com.itis.repository;

import com.itis.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author softi on 19.05.2017.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}