package com.kurowskiandrzej.sdk_demo

import android.content.Context
import com.kurowskiandrzej.sdk_demo.di.sdkMainModule
import com.kurowskiandrzej.sdk_demo.presentation.UiParams
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

object SdkInitializer {
    operator fun invoke(
        context: Context,
        uiParams: UiParams = UiParams(),
    ) {
        val sdkInitModule = module {
            single {
                uiParams
            }
        }

        startKoin {
            androidContext(context)
            modules(
                sdkMainModule,
                sdkInitModule,
            )
        }
    }

    sealed interface ScreenTransition {

        data class Slide(val tween: Int = 700) : ScreenTransition

        data object Scale : ScreenTransition
    }
}
