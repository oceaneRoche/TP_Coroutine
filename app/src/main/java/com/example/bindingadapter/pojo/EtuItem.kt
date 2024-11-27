package com.example.bindingadapter.pojo

import com.google.gson.annotations.SerializedName

data class EtuItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("firstname")
	val firstname: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("age")
	val age: String? = null,

	@field:SerializedName("lastname")
	val lastname: String? = null
){
	override fun toString(): String {
		return "$firstname $lastname $age\n"
	}
}
