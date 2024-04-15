package com.example.galleryapplication.view

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LoadScreenshotButton(onClickAction: ()->Unit){
    run {
        Button(onClick = onClickAction) {
            Text(text = "Load Screenshots")
        }
    }
}