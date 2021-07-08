package com.example.authenticationformexample.di

import androidx.navigation.NavController
import com.example.auth.feature_navigation.AuthFeatureNavigator
import com.example.authenticationformexample.FeatureNavGraphDirections
import javax.inject.Inject


class FeatureNavigator @Inject constructor() :
    AuthFeatureNavigator {
    @Inject lateinit var featureNavController : NavController

    override fun navigateToHomeScreen() =
        featureNavController.navigate(FeatureNavGraphDirections.openHomeScreen())

}