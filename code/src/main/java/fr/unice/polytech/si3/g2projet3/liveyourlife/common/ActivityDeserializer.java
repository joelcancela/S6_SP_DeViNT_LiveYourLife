package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;

import java.lang.reflect.Type;

/**
 * Created by user on 03/05/2017.
 */
public class ActivityDeserializer<E extends Activity> implements JsonDeserializer<E> {
    @Override
    public E deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
