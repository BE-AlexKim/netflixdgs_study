package com.example.kihyun.netflixdgs.study.entities

import jakarta.persistence.*

/**
 *packageName    : com.example.kihyun.netflixdgs.study.entities
 * fileName       : DirectorEntity
 * author         : joy58
 * date           : 2025-03-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-17        joy58       최초 생성
 */
@Entity
@Table(name = "director")
class Director {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    val name: String? = null

    @OneToMany(mappedBy = "director")
    val movies: List<Movie> = emptyList()
}