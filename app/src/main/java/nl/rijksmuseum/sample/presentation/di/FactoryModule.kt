package nl.rijksmuseum.sample.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectDetailsUseCase
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectUseCase
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModelFactory
import nl.rijksmuseum.sample.presentation.viewmodel.DetailsViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideArtObjectViewModelFactory(application: Application,
                                         getArtObjectUseCase: GetArtObjectUseCase):ArtObjectViewModelFactory{
        return ArtObjectViewModelFactory(application,getArtObjectUseCase)
    }
    @Singleton
    @Provides
    fun provideArtObjectDetailsViewModelFactory(application: Application,
                                                getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase):DetailsViewModelFactory{
        return DetailsViewModelFactory(application, getArtObjectDetailsUseCase)
    }
}
