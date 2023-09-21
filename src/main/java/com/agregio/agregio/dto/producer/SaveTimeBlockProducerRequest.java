package com.agregio.agregio.dto.producer;

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
public class SaveTimeBlockProducerRequest {

    private Integer id;

    private Integer timeBlockId;

    private Integer quantity;
}
