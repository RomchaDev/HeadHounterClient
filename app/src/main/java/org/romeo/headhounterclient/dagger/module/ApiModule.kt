package org.romeo.headhounterclient.dagger.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.model.api.BASE_URL
import org.romeo.headhounterclient.model.api.IRetrofitWorker
import org.romeo.headhounterclient.model.api.RetrofitService
import org.romeo.headhounterclient.model.api.RetrofitWorker
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Named(GSON_MAIN)
    fun gson(): Gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .disableHtmlEscaping()
        .create()

    @Provides
    @Singleton
    fun retrofitService(
        @Named(BASE_NAME) baseUrl: String,
        @Named(GSON_MAIN) gson: Gson
    ): RetrofitService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RetrofitService::class.java)

    @Provides
    fun retrofitWorker(service: RetrofitService):
            IRetrofitWorker = RetrofitWorker(service)

    @Provides
    @Named(BASE_NAME)
    fun baseUrl() = BASE_URL

    companion object {
        private const val BASE_NAME = "BASE"
        private const val GSON_MAIN = "GSON_MAIN"
    }
}