package com.lemnos.iconic

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.lemnos.iconic.view.appList.AppList
import com.lemnos.iconic.ui.theme.IconicTheme

class MainActivity : ComponentActivity() {
    //TODO: Implement Room database here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IconicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListScreen(this)
                    //TODO: Conditionally render SwapScreen here
                }
            }
        }
    }
}

@Composable
fun ListScreen(context: Context) {
    ConstraintLayout {
        val (title, header, list) = createRefs()

        Text(
            text = "Iconic",
            fontSize = 70.sp,
            fontFamily = FontFamily.Monospace,
            color = MaterialTheme.colors.surface,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .constrainAs(title) {
                    top.linkTo(parent.top, margin = 16.dp)
                }
        )

        Text(
            text = "Select an app to iconify:",
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.surface,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .constrainAs(header) {
                    top.linkTo(title.bottom, margin = 16.dp)
                }
        )

        AppList(context,
        modifier = Modifier
            .constrainAs(list) {
                top.linkTo(header.bottom, margin = 16.dp)
            }
        )
    }
}