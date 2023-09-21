package com.agregio.agregio.service;

import com.agregio.agregio.domain.TimeBlockOffer;
import com.agregio.agregio.dto.offer.SaveTimeBlockOfferRequest;
import com.agregio.agregio.repository.TimeBlockOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeBlockOfferService {

    private TimeBlockOfferRepository timeBlockOfferRepository;


    public TimeBlockOfferService(TimeBlockOfferRepository timeBlockOfferRepository) {
        this.timeBlockOfferRepository = timeBlockOfferRepository;
    }

    public List<TimeBlockOffer> findAll() {
        return timeBlockOfferRepository.findAll();
    }

    public TimeBlockOffer findById(Integer id) {
        return timeBlockOfferRepository.findById(id);
    }

    public TimeBlockOffer save(SaveTimeBlockOfferRequest saveTimeBlockOfferRequest) {
        TimeBlockOffer timeBlockOfferDb = timeBlockOfferRepository.findById(saveTimeBlockOfferRequest.getId());

        TimeBlockOffer timeBlockOffer = TimeBlockOffer.builder()
                .id(saveTimeBlockOfferRequest.getId())
                .offerId(timeBlockOfferDb.getOfferId())
                .position(timeBlockOfferDb.getPosition())
                .floorPrice(saveTimeBlockOfferRequest.getFloorPrice())
                .quantity(saveTimeBlockOfferRequest.getQuantity())
                .build();

        return timeBlockOfferRepository.save(timeBlockOffer);
    }

    public TimeBlockOffer save(TimeBlockOffer timeBlockOffer) {
        return timeBlockOfferRepository.save(timeBlockOffer);
    }
}
