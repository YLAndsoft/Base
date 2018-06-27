package f.base.utils;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Gson解析工具类
 * Created by DN on 2018/5/4.
 */

public class GsonUtils {

    private GsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T getGsonObject(String data, Class<T> mClass) {
        T result = new Gson().fromJson(data, mClass);
        return result;
    }

    public static <T> List<T> getGsonList(String data, Class<T> klass) {
        return new Gson().fromJson(data, new ListOfSomething<T>(klass));
    }

    public static class ListOfSomething<X> implements ParameterizedType {
        private Class<?> wrapped;
        public ListOfSomething(Class<X> wrapped) {
            this.wrapped = wrapped;
        }
        public Type[] getActualTypeArguments() {
            return new Type[] {wrapped};
        }
        public Type getRawType() {
            return List.class;
        }
        public Type getOwnerType() {
            return null;
        }
    }

}
