package com.lemnos.iconic.view.appList

import android.graphics.drawable.Drawable
import com.lemnos.iconic.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage

@Composable
fun AppItem(appName: String, appIcon: Drawable, packageName: String) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(MaterialTheme.colors.surface, RoundedCornerShape(2.dp))
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (icon, name, button) = createRefs()

            AsyncImage(
                model = appIcon,
                contentDescription = appName,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .constrainAs(icon) {
                        start.linkTo(parent.start, 10.dp)
                        top.linkTo(parent.top, 5.dp)
                    }
            )

            Text(
                text = appName,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.background,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(icon.end, 16.dp)
                        centerVerticallyTo(icon)
                    }
            )

            /*
            TODO: Conditionally render an 'undo' button to revert icon back to default
            Use 'packageName' to search the db and check for custom icon
             */

            AsyncImage(
                model = R.drawable.chevron_right_48px,
                contentDescription = "Navigate to swap screen",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .constrainAs(button) {
                        end.linkTo(parent.end)
                        centerVerticallyTo(icon)
                    }
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                    /*
                    TODO: Call function to display icon swap screen
                    Call function to set the 'packageName, icon, and formattedName' in state
                    */
                    }
            )

        }
    }
}