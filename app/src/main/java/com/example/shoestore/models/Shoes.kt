package com.example.shoestore.models
import java.io.Serializable
data class Shoes(
    var name:String ,
    var color:String,
    var size:String ,
    var type:String ,
    var descrition:String)
    :Serializable{}