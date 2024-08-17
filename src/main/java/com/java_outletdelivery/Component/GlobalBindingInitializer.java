package com.java_outletdelivery.Component;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;

@ControllerAdvice
public class GlobalBindingInitializer {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Double.class, "price",new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    setValue(Double.parseDouble(text));
                } catch (NumberFormatException e) {
                    setValue(null);
                }
            }
        });
        binder.registerCustomEditor(Long.class, "stock",new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) {
                        try {
                            setValue(Long.parseLong(text));
                        } catch (Exception e) {
                            setValue(null);
                        }
                    }
                }
        );
    }
}
