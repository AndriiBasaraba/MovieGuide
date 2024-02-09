package basaraba.adndrii.movieguide.features.ui_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieAnimationView(
    assetName: String,
    modifier: Modifier = Modifier
) {
    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.Asset(assetName)
    )

    LottieAnimation(
        composition = preloaderLottieComposition,
        modifier = modifier,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )
}
