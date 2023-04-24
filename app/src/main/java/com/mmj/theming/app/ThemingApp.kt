package com.mmj.theming.app

import android.app.Application
import io.paperdb.Paper

class ThemingApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }
}