package com.kurowskiandrzej.sdk_demo.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.kurowskiandrzej.sdk_demo.R
import com.kurowskiandrzej.sdk_demo.presentation.nav.SdkApp

class SdkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sdk, container, false).apply {
            findViewById<ComposeView>(R.id.cvSdk).setContent {  SdkApp() }
        }
    }
}
