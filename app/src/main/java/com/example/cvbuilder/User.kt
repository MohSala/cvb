package com.example.cvbuilder

data class User(val firstName: String, val lastName: String, val email:String, val password: String) {
    override fun toString(): String {
        return "firstName: $firstName, lastName:$lastName"
    }
}