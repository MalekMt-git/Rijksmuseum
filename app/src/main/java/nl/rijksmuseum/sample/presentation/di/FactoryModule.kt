package nl.rijksmuseum.sample.presentation.di

import android.app.Application
import com.example.domain.usecase.GetArtObjectDetailsUseCase
import com.example.domain.usecase.GetArtObjectUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.rijksmuseum.sample.presentation.viewmodel.ArtObjectViewModelFactory
import nl.rijksmuseum.sample.presentation.viewmodel.DetailsViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideArtObjectViewModelFactory(getArtObjectUseCase: GetArtObjectUseCase)
    = ArtObjectViewModelFactory(getArtObjectUseCase)

    @Singleton
    @Provides
    fun provideArtObjectDetailsViewModelFactory(getArtObjectDetailsUseCase: GetArtObjectDetailsUseCase)
    = DetailsViewModelFactory(getArtObjectDetailsUseCase)
}
