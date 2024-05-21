package com.ph32395.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import duyndph34554.fpoly.lab_4.ui.theme.Lab_4Theme

class MainActivityBai2Lab4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val images = listOf(R.drawable.anh1, R.drawable.anh2, R.drawable.anh3, R.drawable.anh4, R.drawable.anh5)
            Column {
                Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo"
                )

                HorizontalImageList(imageList = images)
                VerticalImageList(imageList = images)
            }
        }
    }
}

@Composable
fun HorizontalImageList(imageList: List<Int>){
    val scrollState = rememberScrollState()

    Row (modifier = Modifier
        .horizontalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(painter = painterResource(id = image),
                contentDescription = "Image Description",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .width(200.dp)
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        start = if (index == 0) 0.dp else 8.dp,
                        end = 8.dp
                    ))
        }
    }
}

@Composable
fun VerticalImageList(imageList: List<Int>) {
    val scrollState = rememberScrollState()

    Column (modifier = Modifier
        .verticalScroll(scrollState)
        .padding(16.dp)) {
        imageList.forEachIndexed { index, image ->
            Image(painter = painterResource(id = image),
                contentDescription = "Image description",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(
                        top = if (index == 0) 0.dp else 8.dp,
                        bottom = 8.dp
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HorizontalPreview() {
    Lab_4Theme {
//        LoginCompose()
        val images = listOf(R.drawable.anh1, R.drawable.anh2, R.drawable.anh3, R.drawable.anh4, R.drawable.anh5)
        HorizontalImageList(imageList = images)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VerticalPreview() {
    Lab_4Theme {
        val images = listOf(R.drawable.anh1, R.drawable.anh2, R.drawable.anh3, R.drawable.anh4, R.drawable.anh5)
        VerticalImageList(imageList = images)
    }

}