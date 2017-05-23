package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import com.google.gson.*;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;

import java.lang.reflect.Type;

/**
 * Created by user on 17/05/2017.
 */
public class ActionDeserializer implements JsonDeserializer<Action> {
    @Override
    public Action deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        return new Action(jsonObject.get("description").getAsString(), jsonObject.get("image").getAsString());
    }
}
