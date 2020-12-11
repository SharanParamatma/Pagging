package com.india.innovative.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class User : Serializable {

    @field:SerializedName("id")
    var id: String? = null

    @field:SerializedName("name")
    var name: String? = null

    @field:SerializedName("email")
    var email: String? = null

    @field:SerializedName("gender")
    var gender: String? = null

    @field:SerializedName("status")
    var status: String? = null

    @field:SerializedName("created_at")
    var created_at: String? = null

    @field:SerializedName("updated_at")
    var updated_at: String? = null


}