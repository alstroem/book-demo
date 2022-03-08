package dk.alstroem.bookdemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIME_OUT = 60_000

    @Singleton
    @Provides
    fun provideKtorHttpClient(): HttpClient {
        return HttpClient(Android) {

            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Timber.v("Logger Ktor ->", message)
                    }
                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Timber.d("HTTP status:", response.status.value.toString())
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
}
