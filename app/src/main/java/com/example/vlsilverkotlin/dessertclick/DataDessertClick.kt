package com.example.vlsilverkotlin.dessertclick

import com.example.vlsilverkotlin.R


data class DessertClick(
    val imgId: Int,
    val price: Int,
    val startProductionAmount: Int,
    val name: String
)

var allDessertClick = listOf(
    DessertClick(
        R.drawable.cupcake,
        5,
        0,
        "cupcake"
    ),
    DessertClick(
        R.drawable.donut,
        10,
        5,
        "donut"
    ),
    DessertClick(
        R.drawable.eclair,
        15,
        20,
        "eclair"
    ),
    DessertClick(
        R.drawable.froyo,
        30,
        50,
        "froyo"
    ),
    DessertClick(
        R.drawable.gingerbread,
        50,
        100,
        "gingerbread"
    ),
    DessertClick(
        R.drawable.honeycomb,
        100,
        200,
        "honeycomb"
    ),
    DessertClick(
        R.drawable.icecreamsandwich,
        500,
        500,
        "icecreamsandwich"
    ),
    DessertClick(
        R.drawable.jellybean,
        1000,
        1000,
        "jellybean"
    ),
    DessertClick(
        R.drawable.kitkat,
        2000,
        2000,
        "kitkat"
    ),
    DessertClick(
        R.drawable.lollipop,
        3000,
        4000,
        "lollipop"
    ),
    DessertClick(
        R.drawable.marshmallow,
        4000,
        8000,
        "marshmallow"
    ),
    DessertClick(
        R.drawable.nougat,
        5000,
        16000,
        "nougat"
    ),
    DessertClick(
        R.drawable.oreo,
        6000,
        20000,
        "oreo"
    )
)
