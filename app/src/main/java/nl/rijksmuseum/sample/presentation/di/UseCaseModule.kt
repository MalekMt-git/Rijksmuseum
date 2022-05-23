package nl.rijksmuseum.sample.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectDetailsUseCase
import nl.rijksmuseum.sample.domain.usecase.GetArtObjectUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideArtObjectsUseCase(artObjectRepository: ArtObjectRepository):GetArtObjectUseCase{
        return GetArtObjectUseCase(artObjectRepository)
    }
    @Singleton
    @Provides
    fun provideArtObjectDetailsUseCase(artObjectRepository: ArtObjectRepository):GetArtObjectDetailsUseCase{
        return GetArtObjectDetailsUseCase(artObjectRepository)
    }
}
