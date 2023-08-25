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

        /**
         * 설명
         * - Cache.config.getAll(getConfigKeys())를 호출하면 ConfigCacheLoader.loadAll()이 호출된다.
         *
         * 특이사항
         * - getAll 의 파라미터로 전달된 key 들의 조합은 localCache 내부적으로 key 에 맵핑되는 value 가 있어야 한다.
         * - 따라서, 하나라도 일치하는 key 를 제공하거나 모든 key 를 제공하거나 해야 한다.
         * */
        Cache.config.getAll(getConfigKeys())
    }

    private fun getConfigKeys(): List<String>{
        return configRepository.findAllKeys()
    }
}