package com.agregio.agregio.dto.market;

import com.agregio.agregio.domain.MarketName;
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
public class SaveMarketRequest {

    private MarketName name;

}
