package com.example.parlament_app

data class Grade(val grade: Int)
data class Member(val name: String, val numbers: List<Grade>)