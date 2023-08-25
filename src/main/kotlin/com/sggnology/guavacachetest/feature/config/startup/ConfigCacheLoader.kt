package com.sggnology.guavacachetest.feature.config.startup

import com.google.common.cache.CacheLoader
import com.sggnology.guavacachetest.db.entity.Config
import com.sggnology.guavacachetest.db.repository.ConfigRepository

class ConfigCacheLoader(
    private val configRepository: ConfigRepository
): CacheLoader<String, Config>() {
    override fun load(key: String): Config {
        return loadConfig(key)
    }

    private fun loadConfig(key: String): Config {
        return configRepository.findByKey(key) ?: throw RuntimeException("Config not found")
    }

    /**
     * 설명
     * - 제공되는 keys 파라미터와 무관하게 모든 config 들을 로드한다.
     * */
    override fun loadAll(keys: MutableIterable<String>): MutableMap<String, Config> {
        return loadAllConfigs()
    }

    private fun loadAllConfigs(): MutableMap<String, Config> {
        val configs = configRepository.findAll()
        val configMap = mutableMapOf<String, Config>()
        configs.forEach {
            configMap[it.key] = it
        }
        return configMap
    }
}