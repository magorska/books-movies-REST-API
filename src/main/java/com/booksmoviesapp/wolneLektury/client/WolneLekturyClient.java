package com.booksmoviesapp.wolneLektury.client;

import com.booksmoviesapp.config.WolneLekturyClientConfig;
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
    private final WolneLekturyClientConfig wolneLekturyClientConfig;

    public List<WolneLekturySearchedDto> getBooks() {

        URI url = UriComponentsBuilder.fromHttpUrl(wolneLekturyClientConfig.getWolneLekturyApiEndpoint() + "books")
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
