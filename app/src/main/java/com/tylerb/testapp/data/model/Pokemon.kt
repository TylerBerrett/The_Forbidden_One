package com.tylerb.testapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "pokemon")
@JsonClass(generateAdapter = true)
data class Pokemon(
    @PrimaryKey
    val id: Int,
    val name: String
)
