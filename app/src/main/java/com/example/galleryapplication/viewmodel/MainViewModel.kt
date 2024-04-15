package com.example.galleryapplication.viewmodel

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.galleryapplication.model.MediaModel

class MainViewModel : ViewModel() {
    private val _imageUris = mutableStateOf<List<MediaModel>>(emptyList())
    val imageUris: State<List<MediaModel>> = _imageUris

    fun setImageUris(uris: List<Uri>) {
        _imageUris.value = uris.map { MediaModel(it) }
    }
}
