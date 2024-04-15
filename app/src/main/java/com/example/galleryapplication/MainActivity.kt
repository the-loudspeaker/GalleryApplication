package com.example.galleryapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.galleryapplication.view.CombinedView
import com.example.galleryapplication.view.LoadScreenshotButton
import com.example.galleryapplication.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartPage()
        }
    }
}

@Composable
fun StartPage(mainViewModel: MainViewModel = viewModel()) {
    val imageUris by mainViewModel.imageUris
    val pickMultipleMedia = rememberLauncherForActivityResult(PickMultipleVisualMedia()) { uris ->
        mainViewModel.setImageUris(uris)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (imageUris.isNotEmpty()) {
            CombinedView(imageUris = imageUris)
        } else {
            LoadScreenshotButton(
                onClickAction = {
                    pickMultipleMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
                },
            )
        }
    }
}
