package tech.fingercode.data.base

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor constructor(private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(addHeader(request))
    }

    private fun addHeader(request: Request): Request {
        return request.newBuilder()
            .addHeader(AUTHORIZATION, token)
            .build()
    }

    companion object {
        const val AUTHORIZATION = "Authorization"
    }
}