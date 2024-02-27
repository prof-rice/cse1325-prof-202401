package mdi;

import store.Store;

public enum View {
    CUSTOMERS, ORDERS, PRODUCTS;
    private static String[] views = new String[]{"Customers", "Orders", "Products"};
    @Override
    public String toString() {
        return views[this.ordinal()];
    }
}

// Or, using a custom constructor...
/*

public enum View {
    TOOLS("Tools", PLANTS("Plants"), CUSTOMERS("Customers");
    private String string;
    private View(String string) {
        this.string = string;
    }
    @Override
    public String toString() {
        return string;
    }
}

*/
