package com.booksmoviesapp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MovieDbClientConfig {

    @Value("${themoviedb.api.endpoint.prod}")
    private String movieDbApiEndpoint;

    @Value("${themoviedb.api.key}")
    private String apiKey;
}
