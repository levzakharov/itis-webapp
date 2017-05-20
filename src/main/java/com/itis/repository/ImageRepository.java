package com.itis.repository;

import com.itis.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by softi on 19.05.2017.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {

}
