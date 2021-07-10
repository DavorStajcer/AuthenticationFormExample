package com.example.auth.presentation.sign_up.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.auth.databinding.SignUpLayoutBinding
import com.example.auth.presentation.log_in.callbacks.IAuthButtonListener
import com.example.auth.presentation.log_in.form.LogInForm
import com.example.auth.presentation.log_in.viewModel.LogInViewModel
import com.example.auth.presentation.sign_up.form.SignUpForm
import com.example.auth.presentation.sign_up.viewModel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment  : Fragment(), IAuthButtonListener{

    lateinit var binding : SignUpLayoutBinding
    private val viewModel : SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpLayoutBinding.inflate(inflater,container,false)
        binding.authButtonListener = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel.initAuthForm(
                SignUpForm(
                usernameTextInputLayout,
                emailSingUpTextInputLayout,
                passwordSingUpTextInputLayout,
                confirmPasswordTextInputLayout
            ))
            viewModel.observeIsFormValid { isValid ->
                Log.v("viewModelLogIn","GOT IS VALID -> $isValid" )
                signUpButton.isEnabled = isValid
            }
        }

    }
    override fun onAuthButtonClicked() {
        //Do nothing
    }

}