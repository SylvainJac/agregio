package com.agregio.agregio.repository;

import com.agregio.agregio.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfferRepository extends JpaRepository<Offer, String> {

    Offer findById(Integer id);
}
