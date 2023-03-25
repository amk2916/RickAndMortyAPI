package com.example.rickandmorty.domain.helper.mapper

import com.example.rickandmorty.data.server.ServerCharacter
import com.example.rickandmorty.domain.Hero

fun ServerCharacter.toHero() = Hero(
    id = id,
    name = name,
    species = species,
    location = location,
    image = image
)