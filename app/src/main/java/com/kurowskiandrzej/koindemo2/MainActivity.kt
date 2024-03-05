package com.kurowskiandrzej.koindemo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kurowskiandrzej.sdk_demo.ui.theme.KoinDemo2Theme
import com.kurowskiandrzej.sdk_demo.presentation.nav.SdkApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinDemo2Theme {
                SdkApp()
            }
        }
    }
}
