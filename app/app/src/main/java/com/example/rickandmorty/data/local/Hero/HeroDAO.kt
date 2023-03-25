package com.example.rickandmorty.data.local.Hero

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroDAO {
    @Insert
    fun setHero(hero:HeroModelDB):Long

    @Query("Select * from Hero")
    fun getAllHero() :List<HeroModelDB>
}