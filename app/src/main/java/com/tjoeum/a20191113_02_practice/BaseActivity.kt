package com.tjoeum.a20191113_02_practice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    var mContext : Context = this

    abstract fun setupEvents()

    abstract fun setValues()
}