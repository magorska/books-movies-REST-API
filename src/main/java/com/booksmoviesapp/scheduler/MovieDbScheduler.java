package com.booksmoviesapp.scheduler;

import com.booksmoviesapp.domain.MovieDbEntity;
import com.booksmoviesapp.domain.dto.MovieDbSearchedDto;
import com.booksmoviesapp.mapper.MovieDbMapper;
import com.booksmoviesapp.mapper.MovieMapper;
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
    private final MovieDbMapper movieDbMapper;

    @Scheduled(cron = "0 0 0 * * *")
    public List<MovieDbSearchedDto> saveUpComing() {

        List<MovieDbSearchedDto> upComing = movieDbClient.getMovieDbUpComingList();
        List<MovieDbEntity> upComingToSave = movieDbMapper.mapToMovieDbEntityList(upComing);
        movieDbClientRepository.saveAll(upComingToSave);
        return upComing;

    }

    @Scheduled(cron = "0 0 9 * * 5")
    public List<MovieDbSearchedDto> saveTopRated() {

        List<MovieDbSearchedDto> topRated = movieDbClient.getMovieDbTopRatedList();
        List<MovieDbEntity> topRatedToSave = movieDbMapper.mapToMovieDbEntityList(topRated);
        movieDbClientRepository.saveAll(topRatedToSave);
        return topRated;

    }

    @Scheduled(cron = "0 0 0 * * *")
    public List<MovieDbSearchedDto> saveDayTrending() {

        List<MovieDbSearchedDto> dayTrending = movieDbClient.getMovieDbUpComingList();
        List<MovieDbEntity> dayTrendingToSave = movieDbMapper.mapToMovieDbEntityList(dayTrending);
        movieDbClientRepository.saveAll(dayTrendingToSave);
        return dayTrending;

    }

    @Scheduled(cron = "0 0 0 * * *")
    public List<MovieDbSearchedDto> saveWeekTrending() {

        List<MovieDbSearchedDto> weekTrending = movieDbClient.getMovieDbUpComingList();
        List<MovieDbEntity> weekTrendingToSave = movieDbMapper.mapToMovieDbEntityList(weekTrending);
        movieDbClientRepository.saveAll(weekTrendingToSave);
        return weekTrending;

    }


}