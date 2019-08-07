package com.worker8.imgurclient.adapter

import android.util.JsonToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.worker8.imgurclient.model.ImgurResponse
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class DynamicAdapterFactory : JsonAdapter.Factory {
    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        if (annotations.isNotEmpty()) {
            return null; // Annotations? This factory doesn't apply.
        }
        if (!(type is ParameterizedType)) {
            return null; // No type parameter? This factory doesn't apply.
        }
        val parameterizedType = type as ParameterizedType

        // (type as ParameterizedType).actualTypeArguments ---> ImgurGalleryItemBase // generic type
        // (type as ParameterizedType).rawType ---------------> ImgurResponse

        if (parameterizedType.rawType !== ImgurResponse::class.java) {
            return null
        }
        val genericAdapter: JsonAdapter<Any> = moshi.adapter(parameterizedType.actualTypeArguments[0])
        return TheJsonAdapter(genericAdapter)
    }
}

class TheJsonAdapter<T>(val jsonAdapter: JsonAdapter<T>) : JsonAdapter<ImgurResponse<T>>() {
    override fun fromJson(reader: JsonReader): ImgurResponse<T>? {
        val list = arrayListOf<T>()
        reader.beginObject()
        while (reader.hasNext()) {
            //if (reader.peek() == "data"){}
        }
        reader.endArray()
        return null
    }

    override fun toJson(writer: JsonWriter, value: ImgurResponse<T>?) {

    }

}
