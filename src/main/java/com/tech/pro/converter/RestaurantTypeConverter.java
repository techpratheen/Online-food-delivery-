package com.tech.pro.converter;

import com.tech.pro.enums.RestaurantType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;
@Converter(autoApply = true)
public class RestaurantTypeConverter implements AttributeConverter<RestaurantType,String> {
    @Override
    public String convertToDatabaseColumn(RestaurantType restaurantType) {
        if (restaurantType == null) {
            return null;
        }
        return restaurantType.getCode();
    }

    @Override
    public RestaurantType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(RestaurantType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
