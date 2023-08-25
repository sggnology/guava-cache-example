package com.sggnology.guavacachetest.feature.config.startup

import com.google.common.cache.CacheBuilder
import com.sggnology.guavacachetest.cache.Cache
import com.sggnology.guavacachetest.db.repository.ConfigRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class ConfigStartUp(
    private val configRepository: ConfigRepository
) {

    @PostConstruct
    fun postConstruct() {
        Cache.config =  CacheBuilder.newBuilder()
            .maximumSize(1000)
            .build(ConfigCacheLoader(configRepository))

        Cache.config.getAll(getConfigKeys())
    }

    private fun getConfigKeys(): List<String>{
        return configRepository.findAllKeys()
    }
}