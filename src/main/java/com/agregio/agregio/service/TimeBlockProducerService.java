package com.agregio.agregio.service;

import com.agregio.agregio.domain.TimeBlockProducer;
import com.agregio.agregio.dto.producer.SaveTimeBlockProducerRequest;
import com.agregio.agregio.repository.TimeBlockProducerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeBlockProducerService {

    private TimeBlockProducerRepository producerRepository;

    private TimeBlockOfferService timeBlockOfferService;

    public TimeBlockProducerService(TimeBlockProducerRepository producerRepository, TimeBlockOfferService timeBlockOfferService) {
        this.producerRepository = producerRepository;
        this.timeBlockOfferService = timeBlockOfferService;
    }

    public List<TimeBlockProducer> findAll() {
        return producerRepository.findAll();
    }

    public TimeBlockProducer findById(Integer id) {
        return producerRepository.findById(id);
    }

    public TimeBlockProducer save(SaveTimeBlockProducerRequest saveTimeBlockProducerRequest) {
        TimeBlockProducer producer = producerRepository.findById(saveTimeBlockProducerRequest.getId());

        TimeBlockProducer timeBlockProducer = TimeBlockProducer.builder()
                .id(saveTimeBlockProducerRequest.getId())
                .quantity(saveTimeBlockProducerRequest.getQuantity())
                .timeBlockOffer(timeBlockOfferService.findById(saveTimeBlockProducerRequest.getTimeBlockId()))
                .position(producer.getPosition())
                .producerId(producer.getProducerId())
                .build();

        return producerRepository.save(timeBlockProducer);
    }

    public TimeBlockProducer save(TimeBlockProducer timeBlockProducer) {
        return producerRepository.save(timeBlockProducer);
    }
}
