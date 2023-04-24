package com.mmj.theming.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController


enum class AppTheme {
    Light, Dark, Default
}


private val DarkColorScheme = darkColorScheme(
    primary = colorBlue,
    secondary = colorBlue1,
    background = colorBlack,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorWhite
)

private val LightColorScheme = lightColorScheme(
    primary = colorRed,
    secondary = colorBlue1,
    background = colorWhite,
    onPrimary = colorWhite,
    onSecondary = colorWhite,
    onBackground = colorBlack
)

@Composable
fun MyApplicationTheme(
    appTheme: AppTheme,
    isDarkMode: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val colorScheme = when (appTheme) {
        AppTheme.Default -> {
            if (isDarkMode) {
                DarkColorScheme
            } else {
                LightColorScheme
            }
        }
        AppTheme.Light -> {
            LightColorScheme
        }
        AppTheme.Dark -> {
            DarkColorScheme
        }
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = colorScheme.primary,
            darkIcons = false,
        )
    }
    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}