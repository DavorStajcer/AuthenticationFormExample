package com.example.auth.presentation.log_in.viewModel

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(): BaseLogInViewModel(){

    init {
        Log.v("viewModelLogIn","view model initialized" )
    }

    override fun onValidForm() {
        Log.v("viewModelLogIn","Form is valid" )
    super.onValidForm()
    }

    override fun onInvalidForm() {
        Log.v("viewModelLogIn","Form is invalid" )
        super.onInvalidForm()
    }
}


