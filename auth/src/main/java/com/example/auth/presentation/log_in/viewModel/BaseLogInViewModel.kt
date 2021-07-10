package com.example.auth.presentation.log_in.viewModel

import android.util.Log
import com.example.auth.domain.entities.LogInParameters
import com.example.auth.presentation.log_in.form.AuthForm
import com.example.auth.presentation.log_in.form.LogInForm
import com.example.auth.presentation.log_in.form.LogInFormParameters
import com.example.common.BaseViewModel
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject


abstract class BaseLogInViewModel : AuthViewModel<LogInForm,LogInParameters>(), IFormViewModel {


    override val validObservable: Subject<Boolean> = BehaviorSubject.create()
    override var authForm: LogInForm? = null

    override fun subscribeToForm() {
        if(authForm == null)
            return
        authForm?.apply {
            changeObservable.doOnNext {
                emailLayout.error = (it as LogInFormParameters).email.errorMessage
                passwordLayout.error = it.password.errorMessage
                if (it.isValid())
                    onValidForm()
                else
                    onInvalidForm()
            }.subscribe()
        }
    }

    override fun retrieveLogInParameters() : LogInParameters =
        LogInParameters(authForm?.emailLayout?.editText?.text.toString().trim(),authForm?.passwordLayout?.editText?.text.toString().trim())


}