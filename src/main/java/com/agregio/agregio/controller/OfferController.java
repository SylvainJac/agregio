package com.agregio.agregio.controller;

import com.agregio.agregio.domain.Offer;
import com.agregio.agregio.dto.offer.CreateOfferRequest;
import com.agregio.agregio.dto.offer.SaveOfferRequest;
import com.agregio.agregio.service.OfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfferController.class);

    private OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public List<Offer> findAll() {
        LOGGER.info("Find all offers");
        return offerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Offer findById(@PathVariable Integer id) {
        LOGGER.info("Find offer by id '{}'", id);
        return offerService.findById(id);
    }

    @PostMapping
    public Offer create(@RequestBody CreateOfferRequest createOfferRequest) {
        LOGGER.info("Create offer");
        return offerService.create(createOfferRequest);
    }

    @PutMapping
    public Offer save(@RequestBody SaveOfferRequest saveOfferRequest) {
        LOGGER.info("Save offer");
        return offerService.save(saveOfferRequest);
    }
}
