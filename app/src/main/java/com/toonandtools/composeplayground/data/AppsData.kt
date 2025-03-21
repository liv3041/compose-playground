package com.toonandtools.composeplayground.data

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.toonandtools.composeplayground.R

data class AppsData(

    @StringRes val title:Int,
    @DrawableRes val image: Int
)
    val appItems = listOf(
     AppsData(R.string.art_space,R.drawable.art),
     AppsData(R.string.affirmations,R.drawable.affirmations)
    )

