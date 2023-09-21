package com.agregio.agregio.repository;

import com.agregio.agregio.domain.TimeBlockOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeBlockOfferRepository extends JpaRepository<TimeBlockOffer, String> {

    TimeBlockOffer findById(Integer id);
}
