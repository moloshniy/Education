package com.example.education


import androidx.databinding.*
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MyViewModel : ViewModel() {

    val uiState: UIState = UIState("initial State", false)

    fun startAsyncRequest() {

        viewModelScope.launch(Dispatchers.Main) {

            delay(3000)
            uiState.show = true
            uiState.text = "SECOND STATE"

            delay(3000)
            uiState.show = false
            uiState.text = "Third STATE"


//            delay(3000)
//            uiState.copy(_text = "SECOND ONE", _show = true)
//            delay(3000)
//            uiState.copy(_text = "THIRD ONE", _show = false)
//            delay(3000)
//            uiState.copy(_text = "4 ONE", _show = true)
        }
    }

//    companion object {
//        @JvmStatic
//        @BindingAdapter("android:visibility")
//        fun setVisibility(view: View, myString: ObservableField<String>) {
//            Log.e("qqq", "HERE")
//            view.visibility = if (myString.get().equals("1")) View.VISIBLE else View.GONE
//        }
//    }
}