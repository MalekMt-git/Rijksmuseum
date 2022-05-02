package nl.rijksmuseum.sample.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectUseCase
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(application: Application,
    getArtObjectUseCase: GetArtObjectUseCase):ArtObjectViewModelFactory{
        return ArtObjectViewModelFactory(application,getArtObjectUseCase)
    }
}