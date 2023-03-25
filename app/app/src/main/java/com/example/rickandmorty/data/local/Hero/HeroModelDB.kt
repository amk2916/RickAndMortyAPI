package com.example.rickandmorty.data.local.Hero

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Hero")
data class HeroModelDB(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "id") val idServer: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "species")  val species:String,
    @ColumnInfo(name = "location") val location:String,//todo: подумать что хранить в базе, пока храню только название
    @ColumnInfo(name = "name") val image: String // todo: храним пока ссылку с сервера, но рекомендуют хранить файлами и ссылками на файл
)
