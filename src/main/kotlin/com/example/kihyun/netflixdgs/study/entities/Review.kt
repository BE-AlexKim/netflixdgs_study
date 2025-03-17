package com.example.kihyun.netflixdgs.study.entities

import jakarta.persistence.*

/**
 *packageName    : com.example.kihyun.netflixdgs.study.entities
 * fileName       : Review
 * author         : joy58
 * date           : 2025-03-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-17        joy58       최초 생성
 */
@Entity
class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    val rating: Int? = null

    @Column(nullable = true)
    val comment: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    val user: User? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id")
    val movie: Movie? = null
}
