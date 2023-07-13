package com.markaz.currencyconvertor.ui.composables.atoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.R
import com.markaz.currencyconvertor.ui.theme.colorDarkGrey
import com.markaz.currencyconvertor.ui.theme.colorGrey
import com.markaz.currencyconvertor.ui.theme.colorPrimary
import com.markaz.currencyconvertor.ui.theme.colorPrimaryBlue
import com.markaz.currencyconvertor.ui.theme.colorPrimaryPurple
import com.markaz.currencyconvertor.ui.theme.colorSecondary
import com.markaz.currencyconvertor.ui.theme.colorSecondaryTeal
import com.markaz.currencyconvertor.ui.theme.mccTypography
import ir.kaaveh.sdpcompose.sdp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun a_TextField(
    value: String = "",
    label: String = "Hint",
    onValueChanged: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true
) =
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChanged.invoke(it) },
        label = { Text(text = label, style = mccTypography.displaySmall.copy(colorDarkGrey)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorGrey,
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorSecondary,
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(7.sdp),
        singleLine = isSingleLine,
        maxLines = if (isSingleLine) 1 else 3,
        textStyle = mccTypography.displaySmall.copy(colorSecondaryTeal),
        modifier = Modifier
            .then(modifier)
            .wrapContentHeight()
            .fillMaxWidth()
    )


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun a_IconTextField(
    value: String = "",
    label: String = "Hint",
    onValueChanged: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true,
    leadingIcon: Int = R.drawable.ic_lock,
    trailingIcon: Int = R.drawable.ic_eye_password,
    IconEventClick: () -> Unit = {},

    ) {
    var isPasswordVisible = remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChanged.invoke(it) },
        label = { Text(text = label, style = mccTypography.displaySmall.copy(colorGrey)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorGrey,
            focusedBorderColor = colorPrimary,
            focusedLabelColor = colorSecondary,
            containerColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = "",
                tint = colorSecondaryTeal
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = if (isPasswordVisible.value) R.drawable.ic_hide_password else trailingIcon),
                contentDescription = "",
                modifier = Modifier.clickable {
                    isPasswordVisible.value = isPasswordVisible.value.not()
                },
                tint = colorSecondaryTeal
            )
        },
        textStyle = mccTypography.displaySmall.copy(colorSecondaryTeal),
        shape = RoundedCornerShape(7.sdp),
        singleLine = isSingleLine,
        maxLines = if (isSingleLine) 1 else 3,
        modifier = Modifier
            .then(modifier)
            .wrapContentHeight()
            .fillMaxWidth(),
        visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun phoneNumberTextField(
    value: String = "",
    label: String = "",
    onValueChanged: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true,
    leadingIcon: Int = R.drawable.ic_lock,
    IconEventClick: () -> Unit = {}
) = OutlinedTextField(
    value = value,
    onValueChange = { onValueChanged.invoke(it) },
    label = { Text(text = label, style = mccTypography.displaySmall.copy(colorGrey)) },
    colors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = colorGrey,
        focusedBorderColor = colorPrimary,
        focusedLabelColor = colorSecondary,
        containerColor = Color.Transparent
    ),
    leadingIcon = {
        Text(text = "+92 ", style = mccTypography.displaySmall.copy(colorSecondaryTeal))
    },
    textStyle = mccTypography.displaySmall.copy(colorSecondaryTeal),
    shape = RoundedCornerShape(7.sdp),
    singleLine = isSingleLine,
    maxLines = if (isSingleLine) 1 else 3,
    modifier = Modifier
        .then(modifier)
        .wrapContentHeight()
        .fillMaxWidth()
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun leadingIconTextField(
    value: String = "",
    label: String = "",
    onValueChanged: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    isSingleLine: Boolean = true,
    leadingIcon: Int = R.drawable.ic_envelop,
    IconEventClick: () -> Unit = {}
) = OutlinedTextField(
    value = value,
    onValueChange = { onValueChanged.invoke(it) },
    label = { Text(text = label, style = mccTypography.displaySmall.copy(colorGrey)) },
    colors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = colorGrey,
        focusedBorderColor = colorPrimary,
        focusedLabelColor = colorSecondary,
        containerColor = Color.Transparent
    ),
    leadingIcon = {
        Icon(
            painter = painterResource(id = leadingIcon),
            contentDescription = "",
            modifier = Modifier.size(20.sdp),
            tint = colorSecondaryTeal
        )
    },
    shape = RoundedCornerShape(7.sdp),
    singleLine = isSingleLine,
    maxLines = if (isSingleLine) 1 else 3,
    modifier = Modifier
        .then(modifier)
        .wrapContentHeight()
        .fillMaxWidth()
)