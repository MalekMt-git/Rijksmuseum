package nl.rijksmuseum.sample.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.rijksmuseum.sample.data.api.ArtObjectAPIService
import nl.rijksmuseum.sample.data.repository.ArtObjectRepositoryImpl
import nl.rijksmuseum.sample.data.repository.dataSource.ArtObjectRemoteDataSource
import nl.rijksmuseum.sample.data.repository.dataSourceImpl.ArtObjectRemoteDataSourceImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideArtObjectRemoteDatSource(artObjectAPIService: ArtObjectAPIService): ArtObjectRemoteDataSource{
        return ArtObjectRemoteDataSourceImpl(artObjectAPIService)
    }
}
