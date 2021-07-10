package com.example.auth.presentation.log_in.form

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.textfield.TextInputLayout
import io.reactivex.rxjava3.core.Observable

class LogInForm(
      val emailLayout : TextInputLayout,
      val passwordLayout : TextInputLayout,
) : AuthForm(){

    override fun observeForm(){
         changeObservable =  Observable.create { emitter ->
             emailLayout.editText?.addTextChangedListener(object : TextWatcher {
                 override fun beforeTextChanged(
                     s: CharSequence?,
                     start: Int,
                     count: Int,
                     after: Int
                 ) {
                     //Do nothing
                 }
                 override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int){
                     val newLogInFormParameters = LogInFormParameters(s,passwordLayout.editText?.text.toString().trim())
                     emitter?.onNext(LogInFormParameters(s,passwordLayout.editText?.text.toString().trim()))
                     Log.v("viewModelLogIn","NEW LOG IN FOR PARAMS:  ${newLogInFormParameters.email.errorMessage}, ${newLogInFormParameters.password.errorMessage}" )

                 }
                 override fun afterTextChanged(s: Editable?) {
                     //Do nothing
                 }
             })
             passwordLayout.editText?.addTextChangedListener(object : TextWatcher {
                 override fun beforeTextChanged(
                     s: CharSequence?,
                     start: Int,
                     count: Int,
                     after: Int
                 ) {
                     //Do nothing
                 }
                 override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int){
                     emitter?.onNext(LogInFormParameters(emailLayout.editText?.text.toString().trim(),s))
                 }
                 override fun afterTextChanged(s: Editable?) {
                     //Do nothing
                 }
             })
         }
     }

    }


