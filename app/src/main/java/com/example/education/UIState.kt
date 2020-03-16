package com.example.education

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR

data class UIState(
    private var _text: String,
    private var _show: Boolean

) : BaseObservable() {

    var text
        @Bindable get() = _text
         set(value) {
            _text = value
            notifyPropertyChanged(BR.text)
        }

    var show
        @Bindable get() = _show
         set(value) {
            _show = value
            notifyPropertyChanged(BR.show)
        }

    companion object{

        @JvmStatic
        @BindingAdapter ("android:visibility")
        fun bindBoolean(view: ProgressBar, bool:Boolean){
            view.visibility = if(bool) View.VISIBLE else View.GONE
        }
    }



}