package com.example.quickorderapp.util

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

fun encodeUrl(value: String): String {
    return URLEncoder.encode(value, StandardCharsets.UTF_8.toString())
}
