package com.example.galleryapplication.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import com.example.galleryapplication.model.MediaModel

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun CombinedView(imageUris: List<MediaModel>){
    run {
        val pagerState = rememberPagerState(pageCount = { imageUris.size })
        Box {
            BackGroundImage(media = imageUris[pagerState.currentPage])
            BottomMediaList(imageUris, pagerState)
        }
    }
}