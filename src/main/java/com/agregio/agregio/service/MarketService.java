package com.agregio.agregio.service;

import com.agregio.agregio.domain.Market;
import com.agregio.agregio.domain.Offer;
import com.agregio.agregio.domain.Producer;
import com.agregio.agregio.domain.TimeBlockOffer;
import com.agregio.agregio.domain.TimeBlockProducer;
import com.agregio.agregio.dto.market.SaveMarketRequest;
import com.agregio.agregio.repository.MarketRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketService {

    private MarketRepository marketRepository;

    private ProducerService producerService;
    private TimeBlockProducerService timeBlockProducerService;

    public MarketService(MarketRepository marketRepository, ProducerService producerService, TimeBlockProducerService timeBlockProducerService) {
        this.marketRepository = marketRepository;
        this.producerService = producerService;
        this.timeBlockProducerService = timeBlockProducerService;
    }

    public List<Market> findAll() {
        return marketRepository.findAll();
    }

    public List<Offer> findAllOffersByMarket(Integer id) {
        return marketRepository.findById(id).getOffers();
    }

    public List<Producer> findAllProducersByMarket(Integer id) {
        return marketRepository.findById(id).getOffers()
                .stream()
                .map(Offer::getTimeBlockOffers)
                .flatMap(Collection::stream)
                .map(TimeBlockOffer::getTimeBlockProducer)
                .map(TimeBlockProducer::getProducerId)
                .map(producerId -> producerService.findById(producerId))
                .collect(Collectors.toList());
    }

    public Market save(SaveMarketRequest saveMarketRequest) {
        Market market = new Market();
        market.setName(saveMarketRequest.getName());
        return marketRepository.save(market);
    }
}
