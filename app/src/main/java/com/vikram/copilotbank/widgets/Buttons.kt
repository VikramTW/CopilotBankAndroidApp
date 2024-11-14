package com.vikram.copilotbank.widgets

// Create a new composable function called PrimaryButtonCompose
// PrimaryButtonCompose should take a text parameter and a clickListener parameter
// PrimaryButtonCompose should display a button with the text parameter as the button text
// Button background color should be set to the primary color of the app
// rounded corners for the button with radius of 8dp
// text color should be white
// button should have a padding of 10dp


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vikram.copilotbank.R

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.colorPrimary)),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(10.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}

//Create a new composable function called SecondaryButton
//SecondaryButton should take a text parameter and a clickListener parameter
//SecondaryButton should display a button with the text parameter as the button text
//Button rounded corners border color should be set to the secondary color of the app
//Button text color should be set to the secondary color of the app
//Button should be OutlineButton with border color as secondary color

@Composable
fun SecondaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        border = ButtonDefaults.outlinedBorder.copy(),
        modifier = modifier.padding(10.dp)
    ) {
        Text(text = text, color = colorResource(id = R.color.colorSecondary), fontSize = 16.sp)
    }
}

//Create a new composable function called ClickableText
//ClickableText should take a text parameter and a clickListener parameter
//ClickableText should display a text with the text parameter as the text
//Text should be clickable and should call the clickListener when clicked
//Text color should be set to the primary color of the app
//Text should have an underline when clicked
@Composable
fun ClickableText(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = colorResource(id = R.color.colorPrimary),
        fontSize = 16.sp,
        modifier = modifier
            .padding(10.dp)
            .clickable(onClick = onClick)
    )
}