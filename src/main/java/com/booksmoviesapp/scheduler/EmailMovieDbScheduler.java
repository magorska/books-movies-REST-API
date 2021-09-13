package com.booksmoviesapp.scheduler;

import com.booksmoviesapp.config.AdminConfig;
import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Mail;
import com.booksmoviesapp.domain.MovieDbSearched;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.mapper.MovieDbMapper;
import com.booksmoviesapp.repository.BookRepository;
import com.booksmoviesapp.repository.MovieDbClientRepository;
import com.booksmoviesapp.repository.MovieRepository;
import com.booksmoviesapp.repository.ReviewRepository;
import com.booksmoviesapp.service.MovieDbClientService;
import com.booksmoviesapp.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EmailMovieDbScheduler {

    private final SimpleEmailService simpleEmailService;
    private final MovieDbClientService movieDbClientService;
    private final MovieDbMapper movieDbMapper;
    private final AdminConfig adminConfig;

    private static final String SUBJECT = "We know what to watch this weekend!";

    @Scheduled(cron = "0 0 10 * 10 *")
    public void sendInformationEmail() {
        List<MovieDbSearchedDto> savedTopRated = movieDbClientService.topRated();
        List<MovieDbSearched> topRatedList = movieDbMapper.mapToMovieDbList(savedTopRated);

        List<String> topRated = new ArrayList<>();
        topRated.add(topRatedList.get(0).getTitle());
        topRated.add(topRatedList.get(1).getTitle());
        topRated.add(topRatedList.get(2).getTitle());
        topRated.add(topRatedList.get(3).getTitle());
        topRated.add(topRatedList.get(4).getTitle());

        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Here's a list of TOP 5 rated movies at this time : " + topRated
                                + "\n Now you also know what to watch this weekend! :)"
                )
        );
    }
}
