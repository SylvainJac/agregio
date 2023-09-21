package com.agregio.agregio.repository;

import com.agregio.agregio.domain.Producer;
import com.agregio.agregio.domain.TimeBlockOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, String> {

    Producer findById(Integer id);
}
