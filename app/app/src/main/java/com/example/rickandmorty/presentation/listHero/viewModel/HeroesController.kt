package com.example.rickandmorty.presentation.viewModel.listHeroes

import android.view.View
import android.view.ViewParent
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.rickandmorty.R
import com.example.rickandmorty.domain.Hero
import com.example.rickandmorty.presentation.listHero.model.HeroModel
class HeroesController : EpoxyController() {
    var heroes: List<Hero> = emptyList()
    val heroClickLiveData = MutableLiveData<Long>()
    override fun buildModels() {
        heroes.forEach {
            HeroModel(
                it,
                { id -> heroClickLiveData.value = id }
            ).addTo(this)
        }
    }
}