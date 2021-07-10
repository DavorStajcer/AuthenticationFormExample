package com.example.auth.presentation.log_in.viewModel

import com.example.auth.presentation.log_in.form.AuthForm
import com.example.auth.domain.entities.IAuthParams
import com.example.auth.presentation.log_in.form.IFormParameters
import com.example.common.BaseViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject


abstract class AuthViewModel<T : AuthForm,P : IAuthParams> : BaseViewModel(), IFormViewModel {


    override val validObservable: Subject<Boolean> = BehaviorSubject.create()
    abstract  var authForm: T?

    abstract fun subscribeToForm()

    abstract fun retrieveLogInParameters() : P

    fun observeIsFormValid(onNext : (Boolean) -> Unit){
        if(authForm == null)
            return
        validObservable.subscribe(onNext)
    }

    fun initAuthForm(authForm: T) {
        this.authForm = authForm
        authForm.observeForm()
        subscribeToForm()

    }
}