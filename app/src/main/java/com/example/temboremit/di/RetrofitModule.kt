package com.example.temboremit.di

import android.content.Context
import android.content.SharedPreferences
import com.example.temboremit.data.Network.LoginUser
import com.example.temboremit.data.Network.RegisterUser
import com.example.temboremit.domain.repository.LoginUserRepository
import com.example.temboremit.domain.repository.RegisterUserRepository
import com.example.temboremit.domain.useCase.LoginUserUseCase
import com.example.temboremit.domain.useCase.RegisterUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("your_shared_preferences_name", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(sharedPreferences: SharedPreferences): OkHttpClient{
        val token = sharedPreferences.getString("token", "") ?: ""
        val interceptor = Interceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://d5a4-154-70-62-113.ngrok-free.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    //inerfaces
    @Provides
    fun provideLoginInterface(retrofit: Retrofit):LoginUser{
        return retrofit.create(LoginUser::class.java)
    }
    @Provides
    fun provideRegisterInterface(retrofit: Retrofit):RegisterUser{
        return retrofit.create(RegisterUser::class.java)
    }


    //repository

    @Provides
    fun provideLoginRepository(loginUser: LoginUser) :LoginUserRepository{
        return LoginUserRepository(loginUser)
    }

    @Provides
    fun provideRegisterRepository(registerUser: RegisterUser) : RegisterUserRepository{
        return RegisterUserRepository(registerUser)
    }


    //useCase

    @Provides
    fun providesLoginUseCase(registerUserRepository: RegisterUserRepository): RegisterUserUseCase{
        return RegisterUserUseCase(registerUserRepository)
    }

    @Provides
    fun provideLoginUseCase(loginUserRepository: LoginUserRepository) : LoginUserUseCase{
        return LoginUserUseCase(loginUserRepository)
    }

}