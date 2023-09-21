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
public class SaveOfferRequest {

    private Integer id;

    private String name;

    private Integer marketId;
}
