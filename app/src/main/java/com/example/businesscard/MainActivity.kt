package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    NameCard(
        imagePainter = painterResource(R.drawable.android_logo),
        fullName = stringResource(R.string.full_name),
        proffesion = stringResource(R.string.proffesion))

}

@Composable
fun NameCard(
    imagePainter: Painter,
    fullName: String,
    proffesion: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = imagePainter,
            contentDescription = "Android logo",
            modifier = Modifier
                .background(Color.Black)
                .size(100.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = fullName,
            fontWeight = FontWeight.Light,
            fontSize = 40.sp,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = proffesion,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF3ddc84)
        )
    }

}

@Composable
fun DetailsCard() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
       BusinessCardApp()
    }
}