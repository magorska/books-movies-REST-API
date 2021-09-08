package com.booksmoviesapp.scheduler;

import com.booksmoviesapp.config.AdminConfig;
import com.booksmoviesapp.domain.Mail;
import com.booksmoviesapp.domain.Movie;
import com.booksmoviesapp.repository.MovieRepository;
import com.booksmoviesapp.repository.ReviewRepository;
import com.booksmoviesapp.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EmailMovieScheduler {

    private final SimpleEmailService simpleEmailService;
    private final ReviewRepository reviewRepository;
    private final AdminConfig adminConfig;

    private static final String SUBJECT = "Top rated movies last week!";

    @Scheduled(cron = "0 10 * * 1")
    public void sendInformationEmail() {
        List<Movie> topMovies = reviewRepository.topFive();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Here's a list of TOP 3 rated by you movies last week: " + topMovies
                                + "\n Don't forget to recommend them to your friends!"
                )
        );
    }


}
