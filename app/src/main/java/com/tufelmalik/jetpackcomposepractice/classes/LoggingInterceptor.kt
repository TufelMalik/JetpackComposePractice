package com.tufelmalik.jetpackcomposepractice.classes



import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url()
        val headers = request.headers()

        println("Request URL: $url")
        println("Request Headers: $headers")

        return chain.proceed(request)
    }
}
