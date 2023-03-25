package com.example.rickandmorty.data.server

data class ServerCharacter constructor(
    val id: Long,
    val name: String,
    val species: String = "неизвестно",//разновидность
    val location: Location, //последняя известная локация (имя и ссылка)
    val image: String // ссылка на картинку
)
