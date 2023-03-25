package com.example.rickandmorty.data.local.Hero

import com.example.rickandmorty.domain.Hero

interface HeroRepository {
    fun add(hero:Hero)
    fun getAllHeroes():List<Hero>
}

