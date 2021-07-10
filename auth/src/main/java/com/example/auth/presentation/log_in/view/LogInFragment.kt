package com.example.auth.presentation.log_in.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.auth.presentation.log_in.callbacks.IAuthButtonListener
import com.example.auth.databinding.LogInLayoutBinding
import com.example.auth.feature_navigation.AuthFeatureNavigator
import com.example.auth.presentation.log_in.form.LogInForm
import com.example.auth.presentation.log_in.viewModel.LogInViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogInFragment : Fragment(), IAuthButtonListener {

    private lateinit var binding : LogInLayoutBinding
    @Inject lateinit var featureNavigator : AuthFeatureNavigator
    private val viewModel : LogInViewModel by viewModels()

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
        binding.apply {
            viewModel.initAuthForm(LogInForm(emailTextInputLayout,passwordTextInputLayout))
            viewModel.observeIsFormValid { isValid ->
                Log.v("viewModelLogIn","GOT IS VALID -> $isValid" )
                logInButton.isEnabled = isValid
            }
        }

    }

    override fun onAuthButtonClicked() =
        featureNavigator.navigateToHomeScreen()

}