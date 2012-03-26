package pl.tomaszdziurko;

public enum MenuItemEnum {
    
    CLIENTS("Clients"),
    PRODUCTS("Products"),
    ABOUT_US("About us"),
    CONTACT("Contact"),
    NONE("");

    private String label;

    private MenuItemEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
