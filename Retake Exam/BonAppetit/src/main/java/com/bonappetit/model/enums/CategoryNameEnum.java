package com.bonappetit.model.enums;

public enum CategoryNameEnum {
    MAIN_DISH("Heart of the meal, substantial and satisfying; main dish delights taste buds."),
        DESSERT("Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy."),
            COCKTAIL("Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.");
    private final String value;

    private CategoryNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
