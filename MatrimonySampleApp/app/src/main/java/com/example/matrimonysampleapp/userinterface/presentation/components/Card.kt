package com.example.matrimonysampleapp.userinterface.presentation.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.matrimonysampleapp.R
import com.example.matrimonysampleapp.userinterface.presentation.compone.ButtonView

@Composable
fun CardView(
    modifier: Modifier = Modifier,
    profile: com.example.matrimonysampleapp.model.Profile,
    shape: Shape = RoundedCornerShape(10),
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(profile.imageURI)
                .crossfade(true)
                .build(),
            contentDescription = "Image Description",
            placeholder = painterResource(R.drawable.placeholder),
            modifier = Modifier
                .width(400.dp)
                .height(300.dp)
        )

        Text(text = profile.name)
        Row {
            ButtonView(
                onClick = {
                    Toast.makeText(LocalContext.current, "Clicked Yes", Toast.LENGTH_LONG).show()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Green
                )
            ) {}
            ButtonView(
                onClick = {
                    Toast.makeText(LocalContext.current, "Clicked No", Toast.LENGTH_LONG).show()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                ),
                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Black)),
            ) {}
        }
    }
}