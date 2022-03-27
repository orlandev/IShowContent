package com.orlandev.icontent.components.carousel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselContainer(
    modifier: Modifier = Modifier,
    carouselDataList: List<CarouselModel>,
    onCarouselItemClick: (Int) -> Unit //Id for know what item was clicked
) {
    val cardElevation = CardDefaults.cardElevation(
        0.dp,
        0.dp,
        0.dp,
        0.dp,
        0.dp,
    )
    ElevatedCard(
        modifier = modifier,
        elevation = cardElevation,
        shape = RoundedCornerShape(30.dp)
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(carouselDataList) { currentCarouselItem ->
                CarouselItem(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(300.dp)
                        .clickable {
                            //If the ID is -1 no need use click feature
                            if (currentCarouselItem.id != -1) {
                                onCarouselItemClick(currentCarouselItem.id)
                            }
                        },
                    title = currentCarouselItem.title,
                    subtitle = currentCarouselItem.subtitle,
                    imageContent = currentCarouselItem.image
                )
            }
        }
    }
}
