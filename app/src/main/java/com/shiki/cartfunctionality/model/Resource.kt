package com.shiki.cartfunctionality.model


class Resource <out T>(val data: T?)  {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource( data = data)
        fun <T> error(message: String, nothing: Nothing?): Resource<T> =
            Resource(data=null)
    }
}