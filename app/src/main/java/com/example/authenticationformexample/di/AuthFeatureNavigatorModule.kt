package com.example.authenticationformexample.di

import com.example.auth.feature_navigation.AuthFeatureNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AuthFeatureNavigatorModule {

    @Binds
    abstract fun provideFeatureNavigator(featureNavigator: FeatureNavigator) : AuthFeatureNavigator
}