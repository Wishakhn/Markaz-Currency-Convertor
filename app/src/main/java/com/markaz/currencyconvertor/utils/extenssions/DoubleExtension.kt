package com.markaz.currencyconvertor.utils.extenssions

import java.text.DecimalFormat


fun Double.roundToThreeDeci(): Double {
    return DecimalFormat("########0.000").format(this).toDouble()
}