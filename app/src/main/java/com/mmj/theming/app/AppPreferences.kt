package com.mmj.theming.app

import com.mmj.theming.ui.theme.AppTheme
import io.paperdb.Paper

object AppPreferences {

    //region Theme

    const val APP_THEME = "AppTheme"

    fun setTheme(theme: AppTheme) {
        Paper.book().write(APP_THEME, theme)
    }

    fun getTheme(): AppTheme {
        return Paper.book().read(APP_THEME, AppTheme.Default)!!
    }

    //endregion

}