package com.example.practicecompose.di

import com.example.practicecompose.repository.FcmRepository
import com.example.practicecompose.repository.QuoteRepository
import com.example.practicecompose.service.FcmApi
import com.example.practicecompose.service.QuoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class QuoteModule {

    companion object {
        const val BASE_URL = "https://www.jsonkeeper.com/b/"
        const val FCM_BASE_URL = ""
    }

    @Named("quote")
    @Provides
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Named("fcm")
    @Provides
    fun provideFcmBaseUrl(): String {
        return FCM_BASE_URL
    }

    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Named("quote")
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient,@Named("quote") baseUrl: String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Named("fcm")
    @Provides
    fun provideRetrofitForFcm(okHttpClient: OkHttpClient, @Named("fcm") baseUrl: String) =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideQuotesApi(@Named("quote") retrofit: Retrofit): QuoteApi {
        return retrofit.create(QuoteApi::class.java)
    }

    @Provides
    fun provideQuoteRepository(quoteApi: QuoteApi): QuoteRepository {
        return QuoteRepository(quoteApi)
    }

    @Provides
    fun provideFcmApi(@Named("fcm") retrofit: Retrofit) = retrofit.create(FcmApi::class.java)

    @Provides
    fun provideFcmRepository(fcmApi: FcmApi): FcmRepository {
        return FcmRepository(fcmApi)
    }
}