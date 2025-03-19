package com.example.kihyun.netflixdgs.study.service

import com.example.kihyun.netflixdgs.study.entities.Movie
import com.example.kihyun.netflixdgs.study.repositories.MovieRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 *packageName    : com.example.kihyun.netflixdgs.study.service
 * fileName       : MovieService
 * author         : joy58
 * date           : 2025-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-19        joy58       최초 생성
 */
@Service
class MovieService constructor(
    private val movieRepository: MovieRepository
){

    @Transactional
    fun findMovieById(movieId: Long): Movie {
        return movieRepository.findById(movieId).orElseThrow { Exception("Movie Not Found.") }
    }

    @Transactional
    fun findMovieByAll(): MutableList<Movie> {
        return movieRepository.findAll()
    }

}