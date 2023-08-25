package com.sggnology.guavacachetest.feature.config.startup

import com.sggnology.guavacachetest.cache.Cache
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ConfigStartUpTest{

    @Test
    fun configCacheInitializedTest(){
        assert(0 < Cache.config.size()) {"Config cache is empty"}
    }
}