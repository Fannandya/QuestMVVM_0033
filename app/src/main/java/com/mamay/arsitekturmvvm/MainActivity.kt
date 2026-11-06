package com.mamay.arsitekturmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.mamay.arsitekturmvvm.ui.theme.ArsitekturMVVMTheme
import com.mamay.arsitekturmvvm.view.uicontroller.SiswaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArsitekturMVVMTheme {
                SiswaApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
