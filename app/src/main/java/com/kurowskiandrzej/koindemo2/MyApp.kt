package com.kurowskiandrzej.koindemo2

import android.app.Application
import com.kurowskiandrzej.sdk_demo.SdkInitializer
import com.kurowskiandrzej.sdk_demo.presentation.UiParams

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        SdkInitializer(
            context = this,
            uiParams = UiParams(
                small = 22,
                medium = 30,
                large = 50,
                screenTransition = SdkInitializer.ScreenTransition.Slide(),
            )
        )
    }
}
