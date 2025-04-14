package com.dado.passwordinputcomponent.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.dado.passwordinputcomponent.ui.theme.colorContentOnNeutralLow
import com.dado.passwordinputcomponent.ui.theme.colorContentOnNeutralMedium
import com.dado.passwordinputcomponent.ui.theme.colorContentOnNeutralXxHigh

@Composable
fun InputView(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    singleLine: Boolean = true
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            placeholder = placeholder?.let { { Text(it) } },
            isError = isError,
            singleLine = singleLine,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            enabled = enabled,
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                unfocusedPlaceholderColor = colorContentOnNeutralLow,
                focusedPlaceholderColor = colorContentOnNeutralLow,
                unfocusedIndicatorColor = colorContentOnNeutralMedium,
                unfocusedLabelColor = colorContentOnNeutralMedium,
                focusedTrailingIconColor = colorContentOnNeutralXxHigh,
                unfocusedTrailingIconColor = colorContentOnNeutralXxHigh,
                errorTrailingIconColor = colorContentOnNeutralXxHigh,
                disabledTrailingIconColor = colorContentOnNeutralXxHigh,
            )
        )

        if (errorMessage != null && isError) { 8.dp } else { 0.dp }

        Spacer(modifier = Modifier.height(4.dp)) // Small gap between field and error

        if (errorMessage != null && isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}
