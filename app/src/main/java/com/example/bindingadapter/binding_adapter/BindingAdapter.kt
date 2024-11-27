package com.example.bindingadapter.binding_adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.bindingadapter.pojo.EtuItem

@BindingAdapter("arItemToString")
fun arToString(textView: TextView, arItems:ArrayList<EtuItem>?) {
    arItems?.let {
        textView.text = it.joinToString(separator = "\n"){"-> ${it}"}
    }
}