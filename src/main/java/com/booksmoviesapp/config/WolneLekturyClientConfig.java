package com.booksmoviesapp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WolneLekturyClientConfig {

    @Value("${wolnelektury.api.endpoint.prod}")
    private String wolneLekturyApiEndpoint;
}
