package com.booksmoviesapp.scheduler;

import com.booksmoviesapp.config.AdminConfig;
import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Mail;
import com.booksmoviesapp.repository.ReviewRepository;
import com.booksmoviesapp.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EmailBookScheduler {

    private final SimpleEmailService simpleEmailService;
    private final ReviewRepository reviewRepository;
    private final AdminConfig adminConfig;

    private static final String SUBJECT = "Top rated books last month!";

    @Scheduled(cron = "0 10 * 10 *")
    public void sendInformationEmail() {
        List<Book> topBooks = reviewRepository.topThreeBooks();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        "Here's a list of TOP 3 rated by you books last month: " + topBooks
                                + "\n Don't forget to recommend them to your friends!"
                )
        );
    }
}
