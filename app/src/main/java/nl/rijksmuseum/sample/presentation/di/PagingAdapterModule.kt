package nl.rijksmuseum.sample.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nl.rijksmuseum.sample.presentation.adapter.ArtObjectsPagingAdapter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PagingAdapterModule {
    @Singleton
    @Provides
    fun providerPagingArtObjectAdapter() = ArtObjectsPagingAdapter()
}