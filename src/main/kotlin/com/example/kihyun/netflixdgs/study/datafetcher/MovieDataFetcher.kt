package com.example.kihyun.netflixdgs.study.datafetcher

import com.example.kihyun.netflixdgs.study.entities.Movie
import com.example.kihyun.netflixdgs.study.repositories.MovieRepository
import com.example.kihyun.netflixdgs.study.service.MovieService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument

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

    @DgsQuery
    fun movies(): MutableList<Movie> {
        return movieRepository.findAll()
    }

    @DgsQuery
    fun movie(
        @InputArgument movieId: Long
    ): Movie {
        return movieRepository.findById(movieId).orElseThrow { Exception("Movie Not Found.") }
    }
}