package com.example.rickandmorty.presentation.listHero.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.App
import com.example.rickandmorty.R
//import com.example.rickandmorty.data.server.CharactersServiceLogWrapper
//import com.example.rickandmorty.data.server.RetrClient
import com.example.rickandmorty.domain.usecase.GetCharactersUseCase
import com.example.rickandmorty.presentation.listHero.viewModel.HeroesViewModel
import com.example.rickandmorty.presentation.viewModel.listHeroes.HeroesController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var charactersUseCase: GetCharactersUseCase

    private val recycler by lazy { findViewById<RecyclerView>(R.id.recycler) }
    private val controller = HeroesController()
    private var counter = 0

    private val viewModel by lazy { HeroesViewModel(charactersUseCase) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).component.inject(this)

        findViewById<FloatingActionButton>(R.id.floating).apply {
            setOnClickListener {
                viewModel.loadCharacters()
            }
        }

        recycler.layoutManager = LinearLayoutManager(baseContext)
        recycler.adapter = controller.adapter

        viewModel.heroesLiveData.observe(this) {
            with(controller){
                heroes = it
                requestModelBuild()
            }
        }

        controller.heroClickLiveData.observe(this) {
            Log.e("dsfsdf", "click on $it")
        }

    }
}