package bg.softuni.pathfinder.model.enums;

import java.util.List;

public enum CategoryName {
    PEDESTRIAN, BICYCLE, MOTORCYCLE, CAR;

    public static List<CategoryName> getEnumsList() {
        return List.of(CategoryName.PEDESTRIAN, CategoryName.BICYCLE, CategoryName.MOTORCYCLE, CategoryName.CAR);
    }
}
