package com.example.kamuko;

public class DBSchema {
    public static class restaurantTable{
        public static final String NAME = "restaurants";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String IMAGE = "img";
        }
    }

    public static class menuTable{
        public static final String NAME = "menu";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String IMAGE = "img";
            public static final String RESTID = "restId";
        }
    }
}
