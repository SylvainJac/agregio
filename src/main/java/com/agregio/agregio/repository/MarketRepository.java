package com.agregio.agregio.repository;


import com.agregio.agregio.domain.Market;
import com.agregio.agregio.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market, String> {

    Market findById(Integer id);
}
