package com.example.rickandmorty.presentation.listHero.model

import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.rickandmorty.R
import com.example.rickandmorty.domain.Hero
import com.squareup.picasso.Picasso

data class HeroModel(
    private val hero: Hero,
    private val clickAction: (Long) -> Unit
) : EpoxyModelWithHolder<HeroModel.Holder>() {
    init {
        id(hero.id)
    }
    override fun bind(holder: Holder) = with(holder) {
        root?.setOnClickListener {
            clickAction.invoke(hero.id)
        }
        nameHero?.text = hero.name
        locationName?.text = hero.location.name
        species?.text = hero.species
        Picasso.get().load(hero.image).into(image)

    }
    override fun getDefaultLayout() = R.layout.content_list_item

    override fun createNewHolder(parent: ViewParent) = Holder()

    class Holder : EpoxyHolder() {
        var root: View? = null
        var nameHero: TextView? = null
        var locationName: TextView? = null
        var species: TextView? = null
        var image: ImageView? = null

        override fun bindView(itemView: View) {
            root = itemView
            nameHero = itemView.findViewById(R.id.namePerson)
            locationName = itemView.findViewById(R.id.location)
            species = itemView.findViewById(R.id.species)
            image = itemView.findViewById(R.id.pictureHero)
        }
    }
}
