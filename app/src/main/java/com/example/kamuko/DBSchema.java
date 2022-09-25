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
            public static final String PRICE = "price";
            public static final String DESCRIPTION = "description";
        }
    }

    public static class userTable{
        public static final String NAME = "user";
        public static class Cols{
            public static final String ID = "userId";
            public static final String NAME = "name";
            public static final String PASSWORD = "password";
        }
    }

    public static class orderHistoryTable{
        public static final String NAME = "oHistory";
        public static class Cols{
            public static final String ID = "userId";
            public static final String ITEMS = "items";
            public static final String DATE = "date";
            public static final String RESTNAME = "restaurantName";
            public static final String COST = "cost";
        }
    }

    public static class loggedInTable{
        public static final String NAME = "loggedIn";
        public static class Cols{
            public static final String ID = "userId";
            public static final String NAME = "name";
        }
    }

}
