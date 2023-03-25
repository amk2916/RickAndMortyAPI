package com.example.rickandmorty.presentation.listHero.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.domain.Hero
import com.example.rickandmorty.domain.usecase.GetCharactersUseCase

class HeroesViewModel(
    private val charactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val heroesLiveData = MutableLiveData<List<Hero>>()

    fun loadCharacters() {
        charactersUseCase.get(heroesLiveData)

        /*charactersUseCase.get {
            heroesLiveData.value = it
        }*/
    }
}