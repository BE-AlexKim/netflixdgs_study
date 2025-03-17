package com.example.kihyun.netflixdgs.study.datafetcher

import com.example.kihyun.netflixdgs.study.entities.Movie
import com.example.kihyun.netflixdgs.study.repositories.MovieRepository
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import org.springframework.transaction.annotation.Transactional

/**
 *packageName    : com.example.kihyun.netflixdgs.study.datafetcher
 * fileName       : MovieDataFetcher
 * author         : joy58
 * date           : 2025-03-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-17        joy58       최초 생성
 */
@DgsComponent
class MovieDataFetcher(
    private val movieRepository: MovieRepository
) {

    @DgsQuery(field = "movies")
    fun getMovies(): MutableList<Movie> {
        return movieRepository.findAll()
    }

}