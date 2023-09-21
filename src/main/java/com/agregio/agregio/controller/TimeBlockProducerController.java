package com.agregio.agregio.controller;

import com.agregio.agregio.domain.TimeBlockOffer;
import com.agregio.agregio.domain.TimeBlockProducer;
import com.agregio.agregio.dto.offer.SaveTimeBlockOfferRequest;
import com.agregio.agregio.dto.producer.SaveTimeBlockProducerRequest;
import com.agregio.agregio.service.TimeBlockOfferService;
import com.agregio.agregio.service.TimeBlockProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time-block-producers")
public class TimeBlockProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeBlockProducerController.class);

    private TimeBlockProducerService timeBlockOfferService;

    public TimeBlockProducerController(TimeBlockProducerService timeBlockOfferService) {
        this.timeBlockOfferService = timeBlockOfferService;
    }

    @PutMapping
    public TimeBlockProducer save(@RequestBody SaveTimeBlockProducerRequest saveTimeBlockProducerRequest) {
        LOGGER.info("Save time bloc producer");
        return timeBlockOfferService.save(saveTimeBlockProducerRequest);
    }
}
