package com.example.sideeffectsandeffecthandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            Scaffold(scaffoldState = scaffoldState) {
                val counter = produceState(initialValue = 0) {
                    delay(1000L)
                    value++
                }
                if (counter.value % 5 == 0 && counter.value > 0) {
                    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Button(onClick = { }) {
                        Text("Click me: ${counter.value}")
                    }
                }
            }
        }
    }
}

@Composable
fun MyComposable(backPressedDispatcher: OnBackPressedDispatcher) {

    val callback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do something
            }

        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }
    Button(onClick = { /*TODO*/ }) {
        Text("Click me")
    }
}