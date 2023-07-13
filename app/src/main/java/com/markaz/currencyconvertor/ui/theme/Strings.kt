package com.markaz.currencyconvertor.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.markaz.currencyconvertor.R


val appName: String
    @Composable
    get() = stringResource(id = R.string.app_name)
val splashNote: String
    @Composable
    get() = stringResource(id = R.string.splash_note)
val splashSubtitle: String
    @Composable
    get() = stringResource(id = R.string.splash_subtitle)
val authLoginTitle: String
    @Composable
    get() = stringResource(id = R.string.auth_login_title)
val authLoginNote: String
    @Composable
    get() = stringResource(id = R.string.auth_login_note)
val authLoginCreateAccount: String
    @Composable
    get() = stringResource(id = R.string.auth_login_create_account)
val authSignupTitle: String
    @Composable
    get() = stringResource(id = R.string.auth_signup_title)
val authSignupNote: String
    @Composable
    get() = stringResource(id = R.string.auth_signup_note)
val authEmail: String
    @Composable
    get() = stringResource(id = R.string.auth_email)
val authPassword: String
    @Composable
    get() = stringResource(id = R.string.auth_password)
val authCPassword: String
    @Composable
    get() = stringResource(id = R.string.auth_c_password)
val authUsername: String
    @Composable
    get() = stringResource(id = R.string.auth_username)
val authUsernameHint: String
    @Composable
    get() = stringResource(id = R.string.auth_username_hint)
val authEmailHint: String
    @Composable
    get() = stringResource(id = R.string.auth_email_hint)
val authPasswordHint: String
    @Composable
    get() = stringResource(id = R.string.auth_password_hint)
val authCPasswordHint: String
    @Composable
    get() = stringResource(id = R.string.auth_c_password_hint)
val graph: String
    @Composable
    get() = stringResource(id = R.string.graph)
val currencyConvertTitle: String
    @Composable
    get() = stringResource(id = R.string.currency_convert_title)
val multiCurrencyConvertorTitle: String
    @Composable
    get() = stringResource(id = R.string.multi_currency_convertor_title)
val singleCurrencyConvertorTitle: String
    @Composable
    get() = stringResource(id = R.string.single_currency_convertor_title)
val next: String
    @Composable
    get() = stringResource(id = R.string.next)
val start: String
    @Composable
    get() = stringResource(id = R.string.start)
val back: String
    @Composable
    get() = stringResource(id = R.string.back)
val help: String
    @Composable
    get() = stringResource(id = R.string.help)

/*@Composable
fun cardBalanceText(amount: String, currency: String) =
    stringResource(id = R.string.home_fragment_card_balance_pay, balanceTitle, amount, currency)*/


/*
fun maskedCardNumber(maskedStr: String, cardNumber: String) = buildAnnotatedString {

    withStyle(
        style = SpanStyle(
            color = Ground,
            fontSize = 30.sp,
            fontFamily = FontFamily(HeroNewBold),
            letterSpacing = 15.sp
        )
    ) {
        append("${maskedStr}")
    }
    withStyle(
        style = SpanStyle(
            color = Ground, fontSize = 13.sp, fontFamily = FontFamily(HeroNewRegular)
        )
    ) {
        append(" ${cardNumber.takeLast(4)}")
    }
}
*/
