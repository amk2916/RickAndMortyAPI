package com.example.rickandmorty.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.server.CharactersService
import com.example.rickandmorty.data.server.ServerResponce
import com.example.rickandmorty.domain.Hero
import com.example.rickandmorty.domain.helper.mapper.toHero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

fun interface MyCallback<T> {
    fun post(entity: T)
}

interface ListHeroInteractor {
    fun getAll()
    fun getById()
    fun open()
}

interface GetCharactersUseCase {
    //fun get(callback: MyCallback<List<Hero>>)
    fun get(callback: LiveData<List<Hero>>)
}

class GetCharactersUseCaseImpl @Inject constructor(
    private val service: CharactersService
) : GetCharactersUseCase {
    //override fun get(callback: MyCallback<List<Hero>>) {
    override fun get(callback: LiveData<List<Hero>>) {
        service.getCharacters()
            .enqueue(object : Callback<ServerResponce> {
                override fun onResponse(
                    call: Call<ServerResponce>,
                    response: Response<ServerResponce>
                ) {
                    response.body()?.results
                        ?.map { it.toHero() }
                        ?.let {
                            if (callback is MutableLiveData)
                                callback.value = it
                        }
                    //?.let { callback.post(it) }
                }


                override fun onFailure(call: Call<ServerResponce>, t: Throwable) {
                    Log.e("***", "error $t")
                }

            })
    }
}