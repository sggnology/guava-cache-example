package com.sggnology.guavacachetest.db.repository


import com.sggnology.guavacachetest.db.entity.Config
import org.springframework.data.jpa.repository.JpaRepository

interface ConfigRepository: JpaRepository<Config, Long> {
    fun findByKey(key: String): Config?
}