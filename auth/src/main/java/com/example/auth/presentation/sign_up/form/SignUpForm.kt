package com.example.auth.presentation.sign_up.form

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.auth.presentation.log_in.form.AuthForm
import com.google.android.material.textfield.TextInputLayout
import io.reactivex.rxjava3.core.Observable

class SignUpForm(
    val usernameLayout : TextInputLayout,
    val emailLayout : TextInputLayout,
    val passwordLayout : TextInputLayout,
    val confirmPasswordLayout : TextInputLayout,
) : AuthForm(){


    override fun observeForm(){
        changeObservable =  Observable.create { emitter ->

            usernameLayout.editText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    //Do nothing
                }
                override fun onTextChanged(u: CharSequence?, start: Int, before: Int, count: Int){
                    val email = emailLayout.editText?.text.toString().trim()
                    val password = passwordLayout.editText?.text.toString().trim()
                    val confirmPassword = confirmPasswordLayout.editText?.text.toString().trim()
                    val newLogInFormParameters = SingUpFormParameters(u,email,password,confirmPassword)
                    emitter?.onNext(newLogInFormParameters)
                    Log.v("viewModelLogIn","NEW LOG IN FOR PARAMS:  ${newLogInFormParameters.email.errorMessage}, ${newLogInFormParameters.password.errorMessage}" )
                }
                override fun afterTextChanged(s: Editable?) {
                    //Do nothing
                }
            })

            emailLayout.editText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    //Do nothing
                }
                override fun onTextChanged(e: CharSequence?, start: Int, before: Int, count: Int){
                    val username = usernameLayout.editText?.text.toString().trim()
                    val password = passwordLayout.editText?.text.toString().trim()
                    val confirmPassword = confirmPasswordLayout.editText?.text.toString().trim()
                    val newLogInFormParameters = SingUpFormParameters(username,e,password,confirmPassword)
                    emitter?.onNext(newLogInFormParameters)
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
                override fun onTextChanged(p: CharSequence?, start: Int, before: Int, count: Int){
                    val username = usernameLayout.editText?.text.toString().trim()
                    val email = emailLayout.editText?.text.toString().trim()
                    val confirmPassword = confirmPasswordLayout.editText?.text.toString().trim()
                    val newLogInFormParameters = SingUpFormParameters(username,email,p,confirmPassword)
                    emitter?.onNext(newLogInFormParameters)
                }
                override fun afterTextChanged(s: Editable?) {
                    //Do nothing
                }
            })
            confirmPasswordLayout.editText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    //Do nothing
                }
                override fun onTextChanged(cp: CharSequence?, start: Int, before: Int, count: Int){
                    val username = usernameLayout.editText?.text.toString().trim()
                    val email = emailLayout.editText?.text.toString().trim()
                    val password = passwordLayout.editText?.text.toString().trim()
                    val newLogInFormParameters = SingUpFormParameters(username,email,password,cp)
                    emitter?.onNext(newLogInFormParameters)
                }
                override fun afterTextChanged(s: Editable?) {
                    //Do nothing
                }
            })
        }
    }

}


