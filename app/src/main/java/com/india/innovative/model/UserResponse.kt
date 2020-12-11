package com.india.innovative.model

import com.google.gson.annotations.SerializedName

class UserResponse {
    @field:SerializedName("data")
    var users: List<User>? = null
}