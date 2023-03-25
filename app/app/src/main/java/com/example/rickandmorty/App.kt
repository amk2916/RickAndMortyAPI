package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.di.DaggerAppComponent

class App : Application() {

    val component by lazy { DaggerAppComponent.create() }

}