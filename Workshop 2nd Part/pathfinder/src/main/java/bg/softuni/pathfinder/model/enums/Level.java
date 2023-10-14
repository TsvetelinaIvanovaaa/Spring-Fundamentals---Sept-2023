package bg.softuni.pathfinder.model.enums;

import java.util.List;

public enum Level {
    BEGINNER, INTERMEDIATE, ADVANCED;

    public static List<Level> getEnumsList() {
        return List.of(Level.BEGINNER, Level.INTERMEDIATE, Level.ADVANCED);
    }
}
