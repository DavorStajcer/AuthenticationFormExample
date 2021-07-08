package com.example.auth.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.auth.callbacks.IAuthButtonListener
import com.example.auth.databinding.LogInLayoutBinding
import com.example.auth.feature_navigation.AuthFeatureNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogInFragment : Fragment(), IAuthButtonListener {

    private lateinit var binding : LogInLayoutBinding
    @Inject lateinit var featureNavigator : AuthFeatureNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LogInLayoutBinding.inflate(inflater,container,false)
        binding.authButtonListener = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("login","LOG IN VIEW CREATED")

    }

    override fun onAuthButtonClicked() =
        featureNavigator.navigateToHomeScreen()


}