package com.booksmoviesapp.scheduler;

import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.moviedb.client.MovieDbClient;
import com.booksmoviesapp.repository.MovieDbClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MovieDbScheduler {

    private final MovieDbClient movieDbClient;
    private final MovieDbClientRepository movieDbClientRepository;

    @Scheduled(cron = "0 0 * * *")
    public List<MovieDbSearchedDto> saveUpComing() {

        List<MovieDbSearchedDto> upComingToSave = movieDbClient.getMovieDbUpComingList();
        movieDbClientRepository.saveAll(upComingToSave);
        return upComingToSave;

    }

    @Scheduled(cron = "0 9 * * 5")
    public List<MovieDbSearchedDto> saveTopRated() {

        List<MovieDbSearchedDto> topRatedSave = movieDbClient.getMovieDbTopRatedList();
        movieDbClientRepository.saveAll(topRatedSave);
        return topRatedSave;

    }

    @Scheduled(cron = "0 0 * * *")
    public List<MovieDbSearchedDto> saveDayTrending() {

        List<MovieDbSearchedDto> dayTrendingToSave = movieDbClient.getMovieDbUpComingList();
        movieDbClientRepository.saveAll(dayTrendingToSave);
        return dayTrendingToSave;

    }

    @Scheduled(cron = "0 0 * * *")
    public List<MovieDbSearchedDto> saveWeekTrending() {

        List<MovieDbSearchedDto> weekTrendingToSave = movieDbClient.getMovieDbUpComingList();
        movieDbClientRepository.saveAll(weekTrendingToSave);
        return weekTrendingToSave;

    }


}