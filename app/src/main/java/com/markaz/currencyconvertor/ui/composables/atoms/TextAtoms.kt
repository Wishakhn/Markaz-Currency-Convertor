package com.markaz.currencyconvertor.ui.composables.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.ui.theme.mccTypography


@Preview
@Composable
fun a_TextLableLarge(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.labelLarge)


@Preview
@Composable
fun a_TextTitleLarge(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.titleLarge)


@Preview
@Composable
fun a_TextSubtitleLarge(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.headlineLarge)

@Preview
@Composable
fun a_TextLableMedium(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.labelMedium)


@Preview
@Composable
fun a_TextTitleMedium(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.titleMedium)


@Preview
@Composable
fun a_TextSubtitleMedium(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.headlineMedium)


@Preview
@Composable
fun a_TextTitleSmall(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.titleSmall)


@Preview
@Composable
fun a_TextSubtitleSmall(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.headlineSmall)

@Preview
@Composable
fun a_TextBodySmall(text: String = "Loriem Epsium", modifier: Modifier = Modifier) =
    Text(text = text, modifier = modifier, style = mccTypography.bodySmall)
