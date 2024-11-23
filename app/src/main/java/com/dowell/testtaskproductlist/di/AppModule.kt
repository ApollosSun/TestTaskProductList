package com.dowell.testtaskproductlist.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dowell.testtaskproductlist.feature_product.data.data_source.ProductDatabase
import com.dowell.testtaskproductlist.feature_product.data.repository.ProductRepositoryImpl
import com.dowell.testtaskproductlist.feature_product.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductDatabase(app: Application): ProductDatabase {
        return Room.databaseBuilder(
            app,
            ProductDatabase::class.java,
            ProductDatabase.DATABASE_NAME
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                ProductDatabase.populateDatabase(context = app, db = db)
            }
        }).build()
    }

    @Provides
    @Singleton
    fun provideProductRepository(db: ProductDatabase): ProductRepository {
        return ProductRepositoryImpl(db.productDao)
    }

}