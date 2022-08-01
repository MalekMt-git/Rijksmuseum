package nl.rijksmuseum.sample.presentation.di

import com.example.data.repository.ArtObjectRepositoryImpl
import com.example.data.repository.dataSource.ArtObjectDataSource
import com.example.domain.repository.ArtObjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideArtObjectRepository(artObjectDataSource: ArtObjectDataSource): ArtObjectRepository {
        return ArtObjectRepositoryImpl(artObjectDataSource)
    }
}
