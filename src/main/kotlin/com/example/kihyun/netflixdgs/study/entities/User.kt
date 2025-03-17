package com.example.kihyun.netflixdgs.study.entities

import jakarta.persistence.*

/**
 *packageName    : com.example.kihyun.netflixdgs.study.entities
 * fileName       : UserEntity
 * author         : joy58
 * date           : 2025-03-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-17        joy58       최초 생성
 */
@Entity
@Table(name = "users")
class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    val username: String? = null

    @Column(nullable = false)
    val email: String? = null

    @OneToMany(mappedBy = "user")
    val users: List<Review> = emptyList()
}