package com.agregio.agregio.dto.producer;

import com.agregio.agregio.domain.EnergyType;
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
public class CreateProducerRequest {

    private String name;

    private EnergyType type;
}
