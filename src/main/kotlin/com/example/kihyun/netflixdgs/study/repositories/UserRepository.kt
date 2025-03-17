package com.example.kihyun.netflixdgs.study.repositories

import com.example.kihyun.netflixdgs.study.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *packageName    : com.example.kihyun.netflixdgs.study.repositories
 * fileName       : UserRepository
 * author         : joy58
 * date           : 2025-03-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-17        joy58       최초 생성
 */

interface UserRepository: JpaRepository<User, Long> {
}