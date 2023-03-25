package com.example.rickandmorty.domain

import com.example.rickandmorty.data.server.Location

data class Hero (
    val id: Long = 0,
    val name: String = "",
    val species: String,
    val location: Location,
    val image: String
)