package com.kocerlabs.cryptoappmvvm.data.network.model

data class TempModel(
    var name: String,
    var symbol: String,
    var price: Double,
    var changePercent: Double,
    var lineData: ArrayList<Int>,
    var propertyAmount: Double,
    var propertySize: Double,
)
