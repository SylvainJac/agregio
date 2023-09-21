package com.agregio.agregio.controller;

import com.agregio.agregio.domain.Market;
import com.agregio.agregio.domain.Offer;
import com.agregio.agregio.domain.Producer;
import com.agregio.agregio.dto.market.SaveMarketRequest;
import com.agregio.agregio.service.MarketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/markets")
public class MarketController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketController.class);

    private MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public List<Market> findAll() {
        LOGGER.info("Find all markets");
        return marketService.findAll();
    }

    @GetMapping("/{id}/offers")
    public List<Offer> findAllOffersByMarket(@PathVariable Integer id) {
        LOGGER.info("Find all offers by market");
        return marketService.findAllOffersByMarket(id);
    }

    @GetMapping("/{id}/producers")
    public List<Producer> findAllProducersByMarket(@PathVariable Integer id) {
        LOGGER.info("Find all producers by market");
        return marketService.findAllProducersByMarket(id);
    }

    @PostMapping
    public Market save(@RequestBody SaveMarketRequest saveMarketRequest) {
        LOGGER.info("Save market request");
        return marketService.save(saveMarketRequest);
    }
}
