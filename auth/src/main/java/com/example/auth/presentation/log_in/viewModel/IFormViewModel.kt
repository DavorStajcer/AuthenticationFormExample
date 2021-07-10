package com.example.auth.presentation.log_in.viewModel

import io.reactivex.rxjava3.subjects.Subject

interface IFormViewModel {

     val validObservable : Subject<Boolean>


     fun onValidForm() = validObservable.onNext(true)

     fun onInvalidForm() = validObservable.onNext(false)
}