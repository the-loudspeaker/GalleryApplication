package com.example.galleryapplication.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.example.galleryapplication.model.MediaModel

@Composable
fun BackGroundImage(media: MediaModel) {
    Image(
        painter = rememberImagePainter(media.uri),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Fit
    )
}