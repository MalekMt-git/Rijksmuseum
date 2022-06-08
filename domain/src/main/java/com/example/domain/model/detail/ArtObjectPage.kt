package com.example.domain.model.detail

interface ArtObjectPage{
    val adlibOverrides: AdlibOverrides
    val audioFile1: Any?
    val audioFileLabel1: Any?
    val audioFileLabel2: Any?
    val createdOn: String
    val id: String
    val lang: String
    val objectNumber: String
    val plaqueDescription: String
    val similarPages: List<Any>
    val tags: List<Any>
    val updatedOn: String
}