package com.java_outletdelivery.Component;

import com.java_outletdelivery.dto.MenuDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MenuValidator implements Validator {
    //custom validator to check if the input is a valid number:
    @Override
    public boolean supports(Class<?> clazz) {
        return MenuDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    MenuDto dto = (MenuDto) target;

    try {
         Double.parseDouble(String.valueOf(dto.getPrice()));
        Long.parseLong(String.valueOf(dto.getStock()));
    } catch (Exception e){
        errors.rejectValue("price", "price.invalid", " ");
        errors.rejectValue("stock", "stock.invalid", " ");

    }
    }
}
