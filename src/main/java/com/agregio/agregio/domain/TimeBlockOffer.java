package com.agregio.agregio.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ag_time_block_offer")
public class TimeBlockOffer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer position;

    private Integer quantity;

    @Column(name = "offer_id")
    private Integer offerId;

    @Column(name = "floor_price")
    private Integer floorPrice;

    @OneToOne(mappedBy = "timeBlockOffer")
    private TimeBlockProducer timeBlockProducer;
}
