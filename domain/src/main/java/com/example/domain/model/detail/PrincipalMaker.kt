package com.example.domain.model.detail

interface PrincipalMaker{
    val biography: Any?
    val dateOfBirth: String
    val dateOfBirthPrecision: Any?
    val dateOfDeath: String
    val dateOfDeathPrecision: Any?
    val labelDesc: String
    val name: String
    val nationality: Any?
    val occupation: List<String>
    val placeOfBirth: String
    val placeOfDeath: String
    val productionPlaces: List<String>
    val qualification: Any?
    val roles: List<String>
    val unFixedName: String
}