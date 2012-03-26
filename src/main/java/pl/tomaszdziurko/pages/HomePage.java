package pl.tomaszdziurko.pages;

import pl.tomaszdziurko.BasePage;
import pl.tomaszdziurko.MenuItemEnum;

public class HomePage extends BasePage {

    public HomePage() {

    }

    @Override
    public MenuItemEnum getActiveMenu() {
        return MenuItemEnum.NONE;
    }
}
