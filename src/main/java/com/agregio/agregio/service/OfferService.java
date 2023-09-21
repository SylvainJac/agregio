package com.agregio.agregio.service;

import com.agregio.agregio.domain.Offer;
import com.agregio.agregio.domain.TimeBlockOffer;
import com.agregio.agregio.dto.offer.CreateOfferRequest;
import com.agregio.agregio.dto.offer.SaveOfferRequest;
import com.agregio.agregio.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    private TimeBlockOfferService timeBlockOfferService;


    public OfferService(OfferRepository offerRepository, TimeBlockOfferService timeBlockOfferService) {
        this.offerRepository = offerRepository;
        this.timeBlockOfferService = timeBlockOfferService;
    }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    public Offer findById(Integer id) {
        return offerRepository.findById(id);
    }

    public Offer create(CreateOfferRequest createOfferRequest) {
        Offer offer = Offer.builder()
                .name(createOfferRequest.getName())
                .marketId(createOfferRequest.getMarketId())
                .build();

        Offer saved = offerRepository.save(offer);

        for (int position = 0; position <= 8; position++) {
            TimeBlockOffer timeBlockOffer = TimeBlockOffer.builder()
                    .offerId(saved.getId())
                    .position(position)
                    .build();

            timeBlockOfferService.save(timeBlockOffer);
        }

        return offerRepository.findById(saved.getId());
    }

    public Offer save(SaveOfferRequest saveOfferRequest) {
        Offer offer = Offer.builder()
                .id(saveOfferRequest.getId())
                .name(saveOfferRequest.getName())
                .marketId(saveOfferRequest.getMarketId())
                .build();

        return offerRepository.findById(offer.getId());
    }
}
