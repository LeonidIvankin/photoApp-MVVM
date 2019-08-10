package ru.leonidivankin.photoapp_mvvm.model.api;

import androidx.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public final class LiveDataResponseBodyConverterFactory extends Converter.Factory {
    private LiveDataResponseBodyConverterFactory() {
    }

    public static LiveDataResponseBodyConverterFactory create() {
        return new LiveDataResponseBodyConverterFactory();
    }

    /**
     * @deprecated use {@link #create()} instead
     */
    public static LiveDataResponseBodyConverterFactory wrap(Converter.Factory factory) {
        return create();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getRawType() == Response.class) {
                Type subType = parameterizedType.getActualTypeArguments()[0];
                if (subType instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) parameterizedType.getActualTypeArguments()[0];
                }
            }

            if (parameterizedType.getRawType() == Resource.class) {
                Type realType = parameterizedType.getActualTypeArguments()[0];
                return retrofit.nextResponseBodyConverter(this, realType, annotations);
            }
        }
        return retrofit.nextResponseBodyConverter(this, type, annotations);
    }
}
