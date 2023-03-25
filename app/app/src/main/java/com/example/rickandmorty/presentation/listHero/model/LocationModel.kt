package com.example.rickandmorty.presentation.listHero.model

import android.view.ViewParent
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.rickandmorty.R
import com.example.rickandmorty.domain.Location

data class LocationModel(
    private val location: Location,
) : EpoxyModelWithHolder<HeroModel.Holder>(){
    init {
        id(location.id)
    }

    override fun getDefaultLayout() = R.layout.location_info

    override fun createNewHolder(parent: ViewParent): HeroModel.Holder {
        TODO("Not yet implemented")
    }
}