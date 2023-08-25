package com.sggnology.guavacachetest.db.entity

import jakarta.persistence.*

@Entity
@Table(name = "config")
class Config(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    @Column(name = "key", nullable = false)
    var key: String,

    @Column(name = "value", nullable = false)
    var value: String
)