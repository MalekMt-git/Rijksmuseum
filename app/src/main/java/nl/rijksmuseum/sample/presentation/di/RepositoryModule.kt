package nl.rijksmuseum.sample.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.rijksmuseum.sample.data.repository.ArtObjectRepositoryImpl
import nl.rijksmuseum.sample.data.repository.dataSource.ArtObjectRemoteDataSource
import nl.rijksmuseum.sample.domain.repository.ArtObjectRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideArtObjectRepository(artObjectRemoteDataSource: ArtObjectRemoteDataSource): ArtObjectRepository{
        return ArtObjectRepositoryImpl(artObjectRemoteDataSource)
    }
}
