package com.example.vipmenu

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Recipes")
data class Recipes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "dishname")
    var dishName: String = "",

    @ColumnInfo(name = "meal name")
    var mealName: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "imageResourceId")
    var imageResourceId: Int = 0,

    @ColumnInfo(name = "circleImageResourceId")
    var circleImageResourceId: Int = 0,

    @ColumnInfo(name = "buttonText")
    var buttonText: String = ""
) : Serializable
