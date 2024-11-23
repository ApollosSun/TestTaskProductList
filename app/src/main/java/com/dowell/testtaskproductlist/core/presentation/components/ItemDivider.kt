package com.dowell.testtaskproductlist.core.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ItemDivider() {
    HorizontalDivider(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .alpha(0.1f),
        color = Color.White
    )
}