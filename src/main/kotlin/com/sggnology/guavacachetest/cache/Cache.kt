package com.sggnology.guavacachetest.cache

import com.google.common.cache.LoadingCache
import com.sggnology.guavacachetest.db.entity.Config

object Cache {
    lateinit var config: LoadingCache<String, Config>
}