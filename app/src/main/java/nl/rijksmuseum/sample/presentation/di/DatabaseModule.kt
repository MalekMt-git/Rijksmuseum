package nl.rijksmuseum.sample.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.ArtObjectDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ArtObjectDatabase {
        return Room.databaseBuilder(
            context,
            ArtObjectDatabase::class.java, "art_object_database"
        ).build()
    }
}