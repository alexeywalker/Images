package com.example.test_06.screens.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.test_06.R
import com.example.test_06.model.UnsplashImage

@Composable
fun ListContent(items: LazyPagingItems<UnsplashImage>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            count = items.itemCount,
            key = items.itemKey(key = { unsplashImage ->
                unsplashImage.id
            }
            ),
            contentType = items.itemContentType(
            )
        ) { index ->
            val item = items[index]
            item?.let { UnsplashItem(unsplashImage = it) }
        }
    }
}

@Composable
fun UnsplashItem(unsplashImage: UnsplashImage) {
//    val painter = rememberImagePainter(data = unsplashImage.urls.regular) {
//        crossfade(durationMillis = 1000)
//        error(R.drawable.ic_launcher_background)
//
//
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(data = unsplashImage.urls.regular)
//            .allowHardware(false)
            .crossfade(1000)
            .error(R.drawable.ic_launcher_background)
            .placeholder(R.drawable.ic_launcher_background)
            .build()
    )

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .clickable {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://unsplash.com/@${unsplashImage.user.username}?utm_source=SanTest&utm_medium=referral"
                    )
                )
                startActivity(context, browserIntent, null)
            }
            .height(300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painter,
            contentDescription = "Unsplash image",
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(0.5f),
            color = Color.Black
        ) { }
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "")
            
//            Text(
//                text = buildAnnotatedString {
//                    append("photo by")
//                    withStyle(
//                        SpanStyle(fontWeight = FontWeight.Black),
//                        append(unsplashImage.user.username)
//                    )
//                    {}
//                    append("on Unsplash")
//
//                },
//                color = Color.White,
//                fontSize = MaterialTheme.typography.bodyLarge,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
            LikeCounter(
                modifier = Modifier.weight(3f),
                painter = painterResource(R.drawable.ic_launcher_background),
                likes = "${unsplashImage.likes}"
            )
        }
    }
}

@Composable
fun LikeCounter(
    modifier: Modifier,
    painter: Painter,
    likes: String
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            painter = painter,
            contentDescription = "Heart icon",
//            tint = HeartRed
        )
        Divider(modifier = Modifier.width(6.dp))
        
        Text(text = "")
//        Text(
//            text = likes,
//            color = Color.White,
//            fontSize = MaterialTheme.typography.titleLarge,
//            fontWeight = FontWeight.Bold,
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis
//        )
    }
}
