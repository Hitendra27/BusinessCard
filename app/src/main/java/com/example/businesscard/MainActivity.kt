package com.example.businesscard

import android.R.color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  MaterialTheme.colors.background
                ) {
                  BusinessCardApp()
                }
            }
        }
    }
}


@Composable
fun BusinessCardApp() {
    Column(
        Modifier
            .fillMaxSize()
            //.padding(10.dp)
            .background(Color(0xFFd2e8d4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NameCard(
            imagePainter = painterResource(R.drawable.android_logo),
            fullName = stringResource(R.string.full_name),
            proffesion = stringResource(R.string.proffesion)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {

        DetailsCard(
            text = stringResource(R.string.phone_number),
            icon = Icons.Rounded.Phone
        )
        DetailsCard(
            text = stringResource(R.string.website),
            icon = Icons.Rounded.Share
        )
        DetailsCard(
            text = stringResource(R.string.email),
            icon = Icons.Rounded.Email
        )
    }
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
            color = Color(0xFF1C521E)
        )
    }

}

@Composable
fun DetailsCard(
    text: String,
    icon: ImageVector,
) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .padding(start = 50.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.weight(1f),
                tint = Color(0xFF1C521E)
            )
            Text(
                text = text,
                modifier = Modifier
                    .weight(3f)
            )
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
       BusinessCardApp()
    }
}
