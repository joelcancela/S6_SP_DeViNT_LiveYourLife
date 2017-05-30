package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Coconut team.
 */
public enum ActivityType {

    CHRONO(ChronoActivity.class),
    SHUFFLE(ShuffleActivity.class);

    private static final Map<String, ActivityType> ACTIVITY_TYPE_MAP = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(typ -> ACTIVITY_TYPE_MAP.put(typ.toString(), typ));
    }

    private Class<? extends Activity> clazz;

    ActivityType(Class<? extends Activity> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Activity> getClazz() {
        return clazz;
    }

    public static ActivityType getActivotyType(String str) {
        return ACTIVITY_TYPE_MAP.get(str);
    }
}
