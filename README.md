## Minimal gallery Application
A minimal gallery application which allows to pick photos and view them in a carausel.

Originally buiilt as an assignemt for [Alle](https://heyalle.com/).

Application uses Jetpack compose, material design, modern practices and acheives the goal without asking for any storage permissions.
Feel free to give it a try [here](https://bit.ly/galleryapk).

Find the original readme for Alle below.

## Assignment for Alle

### | project notes:

#### Problem Statement:
`
To create a minimal gallery application that loads screenshots from the device and displays them.
`<br>`
The image that is in the center of the horizontal image strip is previewed and has a UI to show the selected state.
As you drag horizontally, the preview changes to display the image at the center. Tapping on the item previews that image with selected state.
`
#### Constraints:
- min API level 21.
- minimal footprint.
- jetpack compose and MVVM.

#### Solution:

**Photo picker and Horizontal Pager**
<br>
Since the app requires access to media files, easiest way is to request the `READ_MEDIA_IMAGES` permission and access all images. Then based on their location, we can pick screenshots.
<br>
But there's two issues:
- Older version of Android require a different permission. READ_EXTERNAL_STORAGE
- Latest Android version allows users to grant partial access to only selected media files. These files can be non screenshots.
<br>

So instead of asking for separate permissions based on Android version and having specific handling for partial file access, I decided to go with [Photo Picker](https://developer.android.com/training/data-storage/shared/photopicker), it allows users to load photos without the app needing to request any permission.
<br>
This not only *keeps the app minimal and privacy friendly* but also *allows users to load screenshots of their choice*.

Using the [Horizontal Pager](https://developer.android.com/reference/kotlin/androidx/compose/foundation/pager/package-summary#HorizontalPager(androidx.compose.foundation.pager.PagerState,androidx.compose.ui.Modifier,androidx.compose.foundation.layout.PaddingValues,androidx.compose.foundation.pager.PageSize,kotlin.Int,androidx.compose.ui.unit.Dp,androidx.compose.ui.Alignment.Vertical,androidx.compose.foundation.gestures.TargetedFlingBehavior,kotlin.Boolean,kotlin.Boolean,kotlin.Function1,androidx.compose.ui.input.nestedscroll.NestedScrollConnection,androidx.compose.foundation.gestures.snapping.SnapPosition,kotlin.Function2)),
A view of all loaded images can be shown at the bottom of the screen. It also allows us to animate to the image user has clicked on. The contentPadding Paddingvalues allow us to center the image strip and round off the view pretty nicely.


### | Architecture:

The project uses `Model-View-ViewModel` architecture.
<br>
- The primary model used is `MediaModel` which stores the contentUri of every image.
- The user input goes to the view. (`CombinedView` & `LoadScreenshotButton`)
- The MainActivity has a composable that triggers photo picker. Updating the list of contentUri for images selected happens in the viewModel `MainViewModel` class.

### | Memory Footprint
The app on it's own has low memory footprint. Using profiler, I noticed an idle memory usage of 97.3 MB once the app was loaded.
<br>
Based on the number of loaded screenshots and their size, memory usage increases. I noted a peak of 450MB when 100 images were loaded and I was scrolling quickly through all of them. The idle memory usage was around 200MB.
<br>
The final release build is 6.5MB in size.

### | Kotlin version
The project uses version 1.9.0 of kotlin.

### | Building & running:
A run configuration is included in the project. Just clicking run in Android studio will run the app.

### | APK:
The final built APK can be found [here](https://bit.ly/galleryapk).

### | Screenshots:
![image 1](https://github.com/the-loudspeaker/GalleryApplication/blob/main/screenshots/Screenshot%20from%202024-04-15%2011-16-46.png?raw=true) ![image 2](https://github.com/the-loudspeaker/GalleryApplication/blob/main/screenshots/Screenshot%20from%202024-04-15%2011-17-18.png?raw=true) ![image 3](https://github.com/the-loudspeaker/GalleryApplication/blob/main/screenshots/Screenshot%20from%202024-04-15%2011-17-36.png?raw=true) ![image 4](https://github.com/the-loudspeaker/GalleryApplication/blob/main/screenshots/Screenshot%20from%202024-04-15%2011-17-48.png?raw=true)
