package com.agregio.agregio.repository;

import com.agregio.agregio.domain.TimeBlockProducer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeBlockProducerRepository extends JpaRepository<TimeBlockProducer, String> {

    TimeBlockProducer findById(Integer id);
}
