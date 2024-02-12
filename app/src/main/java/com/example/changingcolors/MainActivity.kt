package com.example.changingcolors

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.changingcolors.ui.theme.ChangingColorsTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangingColorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                ) {
                    Column(
                        Modifier.fillMaxSize()
                    ) {
                        // remember == don't reset this value
                        val color = remember {
                            mutableStateOf(Color.Yellow)
                        }

                        ColorBox(
                            Modifier
                                .fillMaxSize()
                                .weight(1f)
                        )
                        {
                            color.value = it
                        }

                        Box(
                            modifier = Modifier
                                .background(color.value)
                                .weight(1f)
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f

                )
            )
        }
    )
    {

    }
}

@Preview(showBackground = true)
@Composable
fun ChangingColorsPreview() {
    ChangingColorsTheme {
        //ColorBox()
    }
}