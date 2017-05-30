package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by user on 03/05/2017.
 */
public class ActivityDeserializer<A extends Activity> implements JsonDeserializer<A> {
    @Override
    public A deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        Gson gson = new GsonBuilder().registerTypeAdapter(Action.class, new ActionDeserializer()).create();

        Type listType = new TypeToken<List<List<Action>>>(){}.getType();
        List<List<Action>> tmpList = gson.fromJson(jsonObject.get("actions"), listType);
        MultiChoiceList<Action> list = new MultiChoiceList<>(tmpList);
        String title = jsonObject.get("title").getAsString();
        String desc = jsonObject.get("description").getAsString();
        ActivityType typ = ActivityType.getActivotyType(jsonObject.get("type").getAsString());
        Activity res = null;
        switch(typ) {
            case CHRONO:
                // Nothing more to do
                res = new ChronoActivity(title, desc, list);
                break;
            case SHUFFLE:
                Type queueType = new TypeToken<LinkedList<List<Action>>>(){}.getType();
                Queue<List<Action>> choices = gson.fromJson(jsonObject.get("choices"), queueType);
                Type singleListType = new TypeToken<List<String>>(){}.getType();
                List<String> currentState = gson.fromJson(jsonObject.get("currentState"), singleListType);
                String contextImg = jsonObject.get("context").getAsString();
                res = new ShuffleActivity(title, desc, list, choices, currentState, contextImg);
                break;
        }
        return (A) typ.getClazz().cast(res);
    }
}
