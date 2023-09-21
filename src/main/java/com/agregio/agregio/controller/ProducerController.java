package com.agregio.agregio.controller;

import com.agregio.agregio.domain.Producer;
import com.agregio.agregio.dto.producer.CreateProducerRequest;
import com.agregio.agregio.dto.producer.SaveProducerRequest;
import com.agregio.agregio.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producers")
public class ProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping
    public List<Producer> findAll() {
        LOGGER.info("Find all producers");
        return producerService.findAll();
    }

    @PostMapping
    public Producer create(@RequestBody CreateProducerRequest createProducerRequest) {
        LOGGER.info("Create producer");
        return producerService.create(createProducerRequest);
    }

    @PutMapping
    public Producer save(@RequestBody SaveProducerRequest saveProducerRequest) {
        LOGGER.info("Save producer");
        return producerService.save(saveProducerRequest);
    }
}
