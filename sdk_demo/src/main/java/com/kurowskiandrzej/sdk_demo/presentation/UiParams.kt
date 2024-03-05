package com.kurowskiandrzej.sdk_demo.presentation

import com.kurowskiandrzej.sdk_demo.SdkInitializer

data class UiParams(
    val small: Int = 12,
    val medium: Int = 16,
    val large: Int = 24,
    val screenTransition: SdkInitializer.ScreenTransition = SdkInitializer.ScreenTransition.Slide(),
)
