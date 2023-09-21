package com.agregio.agregio.controller;

import com.agregio.agregio.domain.TimeBlockOffer;
import com.agregio.agregio.dto.offer.SaveTimeBlockOfferRequest;
import com.agregio.agregio.service.TimeBlockOfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time-block-offers")
public class TimeBlockOfferController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeBlockOfferController.class);

    private TimeBlockOfferService timeBlockOfferService;

    public TimeBlockOfferController(TimeBlockOfferService timeBlockOfferService) {
        this.timeBlockOfferService = timeBlockOfferService;
    }

    @PutMapping
    public TimeBlockOffer save(@RequestBody SaveTimeBlockOfferRequest saveTimeBlockOfferRequest) {
        LOGGER.info("Save time bloc offer");
        return timeBlockOfferService.save(saveTimeBlockOfferRequest);
    }
}
