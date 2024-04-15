package com.example.galleryapplication.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.galleryapplication.model.MediaModel
import kotlinx.coroutines.launch

private val MEDIA_ITEM_SIZE = 60.dp
private const val SELECTED_ITEM_SCALE = 1.5f

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomMediaList(uris: List<MediaModel>, pagerState: PagerState) {
    val localCoroutineScope = rememberCoroutineScope()
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.Bottom,
        contentPadding = PaddingValues(horizontal = LocalConfiguration.current.screenWidthDp.dp / 2 - MEDIA_ITEM_SIZE/2)
    ) {
        val scale = if (pagerState.currentPage == it) SELECTED_ITEM_SCALE else 1f
        Image(
            painter = rememberImagePainter(uris[it].uri),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = MEDIA_ITEM_SIZE, height = MEDIA_ITEM_SIZE)
                .scale(scaleX = 1f, scaleY = scale)
                .clickable {
                    localCoroutineScope.launch {
                        pagerState.animateScrollToPage(it)
                    }
                }
        )
    }
}