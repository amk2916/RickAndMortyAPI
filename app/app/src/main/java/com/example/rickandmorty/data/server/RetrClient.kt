package com.example.rickandmorty.data.server

//import com.example.rickandmorty.di.Test
import dagger.Provides
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named


data class ServerResponce  (
    val results: List<ServerCharacter>
)


interface CharactersService {
    @GET("character")
    fun getCharacters(): Call<ServerResponce>
/*
    @GET()
    fun getLocationInfo(A:String): Call<ServerResponce>
*/
}

/*
interface CharactersServiceLogWrapper : CharactersService

class CharactersServiceLogWrapperImpl @Inject constructor(
    //@Test private val charactersService: CharactersService
): CharactersServiceLogWrapper {
    override fun getCharacters(): Call<ServerResponce> {
        // TODO some code
        return throw RuntimeException()//charactersService.getCharacters()
    }

}*/
