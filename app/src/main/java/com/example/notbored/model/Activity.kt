package com.example.notbored.model

import com.google.gson.annotations.SerializedName

/**
 * The model contains the Activity class which has the API attributes
 **/

data class Activity(@SerializedName("activity") var activity: String,
                    @SerializedName("type") var type:String?=null,
                    @SerializedName("price") var price: Float,
                    @SerializedName("participants") var participants: Int)
