package com.kurowskiandrzej.sdk_demo.presentation.nav

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurowskiandrzej.sdk_demo.SdkInitializer
import com.kurowskiandrzej.sdk_demo.presentation.UiParams
import com.kurowskiandrzej.sdk_demo.presentation.screen.calculator.CalculatorScreen
import com.kurowskiandrzej.sdk_demo.presentation.screen.history.HistoryScreen
import com.kurowskiandrzej.sdk_demo.presentation.screen.preview.UiParamsPreviewScreen
import org.koin.compose.koinInject

@Composable
fun SdkApp() {
    val navController = rememberNavController()

    val uiParams = koinInject<UiParams>()

    NavHost(
        navController = navController,
        startDestination = Route.CALCULATOR,
        enterTransition = {
            when (val transitionParams = uiParams.screenTransition) {
                SdkInitializer.ScreenTransition.Scale -> {
                    scaleIn(
                        animationSpec = tween(220, delayMillis = 90),
                        initialScale = .9f,
                    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
                }

                is SdkInitializer.ScreenTransition.Slide -> {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(transitionParams.tween),
                    )
                }
            }
        },
        exitTransition = {
            when (val transitionParams = uiParams.screenTransition) {
                SdkInitializer.ScreenTransition.Scale -> {
                    scaleOut(
                        animationSpec = tween(
                            durationMillis = 220,
                            delayMillis = 90
                        ),
                        targetScale = 1.1f,
                    ) + fadeOut(tween(delayMillis = 90))
                }

                is SdkInitializer.ScreenTransition.Slide -> {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        animationSpec = tween(transitionParams.tween)
                    )
                }
            }
        },
        popEnterTransition = {
            when (val transitionParams = uiParams.screenTransition) {
                SdkInitializer.ScreenTransition.Scale -> {
                    scaleIn(
                        animationSpec = tween(220, delayMillis = 90),
                        initialScale = .9f,
                    ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
                }

                is SdkInitializer.ScreenTransition.Slide -> {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(transitionParams.tween),
                    )
                }
            }
        },
        popExitTransition = {
            when (val transitionParams = uiParams.screenTransition) {
                SdkInitializer.ScreenTransition.Scale -> {
                    scaleOut(
                        animationSpec = tween(
                            durationMillis = 220,
                            delayMillis = 90
                        ),
                        targetScale = 1.1f,
                    ) + fadeOut(tween(delayMillis = 90))
                }

                is SdkInitializer.ScreenTransition.Slide -> {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(transitionParams.tween)
                    )
                }
            }
        },
    ) {
        composable(Route.CALCULATOR) {
            CalculatorScreen(
                navController = navController,
            )
        }

        composable(Route.HISTORY) {
            HistoryScreen(
                navController = navController,
            )
        }

        composable(Route.UI_PARAMS_PREVIEW) {
            UiParamsPreviewScreen(
                navController = navController,
            )
        }
    }
}
