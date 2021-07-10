package com.example.auth.presentation.log_in.form

import com.example.auth.domain.entities.IAuthParams
import io.reactivex.rxjava3.core.Observable

abstract  class AuthForm {

    lateinit var changeObservable : Observable<IFormParameters>


    abstract fun observeForm( )

}