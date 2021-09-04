package com.booksmoviesapp.scheduler;

import com.booksmoviesapp.config.AdminConfig;
import com.booksmoviesapp.repository.BookRepository;
import com.booksmoviesapp.repository.MovieRepository;
import com.booksmoviesapp.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmailMovieScheduler {

    private final SimpleEmailService simpleEmailService;
    private final MovieRepository movieRepository;
    private final AdminConfig adminConfig;

    private static final String SUBJECT = "Top rated movies last week!";

//    @Scheduled(cron = "0 10 * * 1")
//    public void sendInformationEmail() {
//        simpleEmailService.send(
//                new Mail(
//                        adminConfig.getAdminMail(),
//                        SUBJECT,
//                        "Here's a list of TOP 3 rated by you movies last week: " +
//                                + "\n Don't forget to recommend them to your friends!",
//                        null
//                )
//        );
//    }


}
