package com.agregio.agregio.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveTimeBlockOfferRequest {

    private Integer id;

    private Integer quantity;

    private Integer floorPrice;
}
