package tech.fingercode.data.service

import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tech.fingercode.data.BuildConfig
import tech.fingercode.data.base.HeaderInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    private var baseUrl = ""

    private val authToken = ""

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        gsonConverterFactory: GsonConverterFactory,
        @BaseUrl baseUrl: String
    ): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(gsonConverterFactory)
    }

    @Provides
    @Singleton
    fun provideHttpBuilder(context: Context) =
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val httpLogInterceptor = HttpLoggingInterceptor()
                httpLogInterceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(httpLogInterceptor)

                val chuck = ChuckInterceptor(context)
                addInterceptor(chuck)
            }
            val headerInterceptor = HeaderInterceptor(authToken)
            addInterceptor(headerInterceptor)
            readTimeout(60L, TimeUnit.SECONDS)
            connectTimeout(60L, TimeUnit.SECONDS)
        }

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideConnectivity(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(
        httpBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder
    ): Retrofit {
        return retrofitBuilder.client(httpBuilder.build())
            .build()
    }
}