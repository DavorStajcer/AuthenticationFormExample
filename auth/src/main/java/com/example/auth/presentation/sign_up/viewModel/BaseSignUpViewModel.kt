package com.example.auth.presentation.sign_up.viewModel

import android.util.Log
import com.example.auth.domain.entities.LogInParameters
import com.example.auth.domain.entities.SingUpParameters
import com.example.auth.presentation.log_in.viewModel.AuthViewModel
import com.example.auth.presentation.sign_up.form.SignUpForm
import com.example.auth.presentation.sign_up.form.SingUpFormParameters

abstract class BaseSignUpViewModel (

)  : AuthViewModel<SignUpForm,SingUpParameters>() {

        override var authForm: SignUpForm? = null

        override fun subscribeToForm() {
                if(authForm == null)
                        return
                authForm?.apply {
                        changeObservable.doOnNext {
                                usernameLayout.error = (it as SingUpFormParameters).username.errorMessage
                                emailLayout.error = it.email.errorMessage
                                passwordLayout.error = it.password.errorMessage
                                confirmPasswordLayout.error = it.confirmPassword.errorMessage
                                if (it.isValid())
                                        onValidForm()
                                else
                                        onInvalidForm()
                        }.subscribe()
                }
        }

        override fun retrieveLogInParameters(): SingUpParameters =
                SingUpParameters(
                authForm?.emailLayout?.editText?.text.toString().trim(),
                authForm?.passwordLayout?.editText?.text.toString().trim(),
                authForm?.usernameLayout?.editText?.text.toString().trim(),
                authForm?.confirmPasswordLayout?.editText?.text.toString().trim(),
                        )
}