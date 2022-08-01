package nl.rijksmuseum.sample.presentation.di

import com.example.data.api.ArtObjectAPIService
import com.example.data.db.ArtObjectDatabase
import com.example.data.repository.dataSource.ArtObjectDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideArtObjectRemoteDatSource(artObjectAPIService: ArtObjectAPIService, artObjectDatabase : ArtObjectDatabase): ArtObjectDataSource {
        return ArtObjectDataSource(artObjectAPIService, artObjectDatabase)
    }
}
