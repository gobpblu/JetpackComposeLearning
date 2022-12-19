package com.example.modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifiers.ui.theme.JetpackComposeRowsColumnsBasicSizingTheme

class ModifiersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxHeight(0.5f)
                    .width(300.dp)
                    .border(1.dp, Color.Cyan)
                    .padding(5.dp)
                    .border(1.dp, Color.Magenta)
                    .padding(5.dp)
                    .border(1.dp, Color.Red)
                    .padding(10.dp)
            ) {
                Text("Hello", modifier = Modifier
                    .border(1.dp, Color.Yellow)
                    .padding(5.dp)
                    .offset(20.dp, 20.dp)
                    .border(1.dp, Color.Gray)
                    .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                Text("World", modifier = Modifier.clickable {

                })
            }
        }
    }
}