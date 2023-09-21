package com.agregio.agregio.service;

import com.agregio.agregio.domain.Producer;
import com.agregio.agregio.domain.TimeBlockProducer;
import com.agregio.agregio.dto.producer.CreateProducerRequest;
import com.agregio.agregio.dto.producer.SaveProducerRequest;
import com.agregio.agregio.repository.ProducerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private ProducerRepository producerRepository;

    private TimeBlockProducerService timeBlockProducerService;

    public ProducerService(ProducerRepository producerRepository, TimeBlockProducerService timeBlockProducerService) {
        this.producerRepository = producerRepository;
        this.timeBlockProducerService = timeBlockProducerService;
    }

    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    public Producer findById(Integer id) {
        return producerRepository.findById(id);
    }

    public Producer create(CreateProducerRequest saveProducerRequest) {
        Producer producer = Producer.builder()
                .name(saveProducerRequest.getName())
                .type(saveProducerRequest.getType())
                .build();

        Producer saved = producerRepository.save(producer);

        for (int position = 0; position <= 8; position++) {
            TimeBlockProducer timeBlockOffer = TimeBlockProducer.builder()
                    .producerId(saved.getId())
                    .position(position)
                    .build();

            timeBlockProducerService.save(timeBlockOffer);
        }

        return producerRepository.findById(producer.getId());
    }

    public Producer save(SaveProducerRequest saveProducerRequest) {
        Producer producer = Producer.builder()
                .id(saveProducerRequest.getId())
                .name(saveProducerRequest.getName())
                .type(saveProducerRequest.getType())
                .build();

        return producerRepository.save(producer);
    }
}
