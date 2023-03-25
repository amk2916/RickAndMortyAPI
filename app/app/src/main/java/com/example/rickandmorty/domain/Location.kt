package com.example.rickandmorty.domain

class Location (
    val id: Long, //id
    val nameLocation: String, //наименование локации
    val type: String, //тип локации (планета, космос и т.д.)
    val dimension: String //измерение
)