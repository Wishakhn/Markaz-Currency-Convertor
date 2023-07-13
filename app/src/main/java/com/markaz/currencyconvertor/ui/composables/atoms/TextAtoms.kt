package com.markaz.currencyconvertor.ui.composables.atoms

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.markaz.currencyconvertor.ui.theme.colorCharcoal
import com.markaz.currencyconvertor.ui.theme.colorSecondary
import com.markaz.currencyconvertor.ui.theme.mccTypography


@Preview
@Composable
fun a_TextLableLarge(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Center
) = Text(text = text, modifier = modifier, style = mccTypography.labelLarge, textAlign = align)


@Preview
@Composable
fun a_TextTitleLarge(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Center,
    color: Color = colorSecondary
) = Text(
    text = text,
    modifier = modifier,
    style = mccTypography.titleLarge.copy(color),
    textAlign = align
)


@Preview
@Composable
fun a_TextSubtitleLarge(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    color: Color = colorCharcoal,
    align: TextAlign = TextAlign.Center
) = Text(
    text = text,
    modifier = modifier,
    style = mccTypography.headlineLarge.copy(color),
    textAlign = align
)

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
fun a_TextBodyLarge(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Center
) = Text(text = text, modifier = modifier, style = mccTypography.bodyLarge, textAlign = align)

@Preview
@Composable
fun a_TextDisplayLarge(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Center,
    color: Color = colorSecondary
) = Text(
    text = text,
    modifier = modifier,
    style = mccTypography.displayLarge.copy(color = color),
    textAlign = align
)
@Preview
@Composable
fun a_TextDisplayMedium(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Center,
    color: Color = colorSecondary
) = Text(
    text = text,
    modifier = modifier,
    style = mccTypography.bodyMedium.copy(color = color),
    textAlign = align
)

@Preview
@Composable
fun a_TextDisplaySmall(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Center,
    color: Color = colorSecondary
) = Text(
    text = text,
    modifier = modifier,
    style = mccTypography.displaySmall.copy(color),
    textAlign = align
)

@Preview
@Composable
fun a_TextBodySmall(
    text: String = "Loriem Epsium",
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Center
) = Text(text = text, modifier = modifier, style = mccTypography.bodySmall, textAlign = align)


@Composable
fun HintText(text: String, modifier: Modifier = Modifier.wrapContentSize()) =
    Text(
        text = text,
        style = mccTypography.headlineSmall,
        modifier = Modifier.then(modifier)
    )