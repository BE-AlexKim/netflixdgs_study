package com.example.kihyun.netflixdgs.study.entities

import jakarta.persistence.*
import java.time.LocalDate

/**
 *packageName    : com.example.kihyun.netflixdgs.study.entities
 * fileName       : Movie
 * author         : joy58
 * date           : 2025-03-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-17        joy58       최초 생성
 */
@Entity
class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    val title: String? = null

    @Column(nullable = false)
    val releaseDate: LocalDate? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "director_id")
    val director: Director? = null

    @OneToMany(mappedBy = "movie")
    val reviews: List<Review> = emptyList()
}