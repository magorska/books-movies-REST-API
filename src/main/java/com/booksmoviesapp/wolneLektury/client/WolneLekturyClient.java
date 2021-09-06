package com.booksmoviesapp.wolneLektury.client;

import com.booksmoviesapp.domain.dto.WolneLekturySearchedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WolneLekturyClient {

    private final RestTemplate restTemplate;

    @Value("${wolnelektury.api.endpoint.prod}")
    private String wolneLekturyEndpoint;

    public List<WolneLekturySearchedDto> getBooks() {

        URI url = UriComponentsBuilder.fromHttpUrl(wolneLekturyEndpoint + "/books")
                .build()
                .encode()
                .toUri();
        System.out.println(url);

        WolneLekturySearchedDto[] searchResponse = restTemplate.getForObject(url, WolneLekturySearchedDto[].class);

        return Optional.ofNullable(searchResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
}
