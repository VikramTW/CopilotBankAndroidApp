package com.vikram.copilotbank.widgets

// Create a new composable function called InputTextField
// InputTextField should take a label parameter, a value parameter, and an onValueChange parameter
// InputTextField should display a text field with the label parameter as the label
// InputTextField should display the value parameter as the value of the text field
// InputTextField should call the onValueChange parameter when the value of the text field changes
// InputTextField should have a padding of 10dp
// InputTextField should have a border color of the divider color of the app
// InputTextField should have a border width of 1dp
// InputTextField should have rounded corners with a radius of 10dp


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.vikram.copilotbank.R


@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = 1,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth(),
        label = label,
        placeholder = placeholder,
        isError = isError,
        enabled = enabled,
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.divideColor),
            focusedBorderColor = colorResource(id = R.color.divideColor),
        )
    )
}

// Example usage:
@Composable
fun ExampleScreen() {
    var text by remember { mutableStateOf("") }

    RoundedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") },
        placeholder = { Text("Type something...") }
    )
}

