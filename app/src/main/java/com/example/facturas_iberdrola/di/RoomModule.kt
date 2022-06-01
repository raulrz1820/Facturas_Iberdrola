package com.example.facturas_iberdrola.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.facturas_iberdrola.database.DatabaseFacturas
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val FACTURA_DATABASE_NAME = "factura_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DatabaseFacturas::class.java, FACTURA_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: DatabaseFacturas) = db.getFacturaDao()}