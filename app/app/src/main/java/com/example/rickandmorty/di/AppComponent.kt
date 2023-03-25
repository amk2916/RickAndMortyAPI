package com.example.rickandmorty.di

import com.example.rickandmorty.data.server.CharactersService
import com.example.rickandmorty.data.server.ServerResponce
import com.example.rickandmorty.domain.usecase.GetCharactersUseCase
import com.example.rickandmorty.domain.usecase.GetCharactersUseCaseImpl
import com.example.rickandmorty.presentation.listHero.view.MainActivity
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Call

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import javax.inject.Named


@Component(
    modules = [
        RetrofitClientModule::class,/*, ServiceBinds::class*/
        BindsUseCases::class
    ]
) //граф зависимости
interface AppComponent {
    fun inject(act: MainActivity)
}

@Module
interface BindsUseCases {

    @Binds
    fun bindGetCharactersUseCase(uc: GetCharactersUseCaseImpl): GetCharactersUseCase
}


@Module
class RetrofitClientModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideCharactersService(
        retrofit: Retrofit
    ): CharactersService = retrofit.create()

    /*@Provides
    fun provideCharactersServiceLogWrapper(
        charactersService: CharactersService
    ): CharactersServiceLogWrapper = CharactersServiceLogWrapperImpl(
        charactersService
    )*/
}

/*
@Named("test")
annotation class Test
*/

/*
@Module
interface ServiceBinds {

    @Binds
    fun bindCharactersServiceLogWrapper343(
        service: CharactersServiceLogWrapperImpl
    ): CharactersServiceLogWrapper


    */
/*
    @Binds
    fun bindCharactersServiceLogWrapper343(
        service: БМВ
    ): Чехол

    @Binds
    fun bindCharactersServiceLogWrapper343(
        service: БМВ
    ): Бантик

    @Binds
    fun bindCharactersServiceLogWrapper343(
        service: БМВ
    ): Коропка
     *//*


    @Binds
    fun bindCharactersServiceLogWrapper(
        service: CharactersServiceLogWrapper
    ): CharactersService
}
*/

