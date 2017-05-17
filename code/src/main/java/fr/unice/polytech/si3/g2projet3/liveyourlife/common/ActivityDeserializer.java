package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by user on 03/05/2017.
 */
public class ActivityDeserializer<E extends Activity> implements JsonDeserializer<Activity> {
    @Override
    public Activity deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        Gson gson = new GsonBuilder().registerTypeAdapter(Action.class, new ActionDeserializer()).create();

        Type listType = new TypeToken<List<List<Action>>>(){}.getType();
        List<List<ChronoAction>> tmpList = gson.fromJson(jsonObject.get("actions"), listType);
        MultiChoiceList<ChronoAction> list = new MultiChoiceList<>(tmpList);
        String title = jsonObject.get("title").getAsString();
        ActivityType typ = ActivityType.getActivotyType(jsonObject.get("type").getAsString());
        try {
            return typ.getClazz().getConstructor(String.class, MultiChoiceList.class).newInstance(title, list);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
