package co.com.jdr.pruebacondorlabs.core

import android.content.Context
import android.widget.Toast

fun Context.toast(text: String, length: Int = Toast.LENGTH_SHORT) =
    this.let { Toast.makeText(it, text, length).show() }

fun Context.getString(resId: Int) =
    getString(resId)