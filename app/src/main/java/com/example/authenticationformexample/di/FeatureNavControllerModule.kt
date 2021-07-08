package com.example.authenticationformexample.di

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.authenticationformexample.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped


@Module
@InstallIn(ActivityComponent::class)
class FeatureNavControllerModule {

    @ActivityScoped
    @Provides
    fun provideFeatureNavController(activity : FragmentActivity) : NavController{
        return activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!.findNavController()
    }
}