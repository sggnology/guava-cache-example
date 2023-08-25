package com.sggnology.guavacachetest.db.repository


import com.sggnology.guavacachetest.db.entity.Config
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ConfigRepository: JpaRepository<Config, Long> {
    fun findByKey(key: String): Config?

    @Query("""
        select c.key from Config c
    """)
    fun findAllKeys(): List<String>
}