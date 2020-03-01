package com.example.www.letscook.objects

class RecipeDTO(
    val id: Int,
    val title: String,
    val rating: Int,
    var image: String,
    var instructions: String
) {
    constructor(id: Int, title: String)
            : this(id, title,0,"","")
}