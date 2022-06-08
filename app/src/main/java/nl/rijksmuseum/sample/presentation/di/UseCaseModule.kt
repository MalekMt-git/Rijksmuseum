package nl.rijksmuseum.sample.presentation.di

import com.example.domain.repository.ArtObjectRepository
import com.example.domain.usecase.GetArtObjectDetailsUseCase
import com.example.domain.usecase.GetArtObjectUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideArtObjectsUseCase(artObjectRepository: ArtObjectRepository): GetArtObjectUseCase {
        return GetArtObjectUseCase(artObjectRepository)
    }
    @Singleton
    @Provides
    fun provideArtObjectDetailsUseCase(artObjectRepository: ArtObjectRepository): GetArtObjectDetailsUseCase {
        return GetArtObjectDetailsUseCase(artObjectRepository)
    }
}
