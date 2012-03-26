package pl.tomaszdziurko;

import org.apache.wicket.markup.html.WebPage;
import pl.tomaszdziurko.pages.HomePage;
import pl.tomaszdziurko.pages.aboutus.OurSkillsPage;
import pl.tomaszdziurko.pages.aboutus.TeamPage;
import pl.tomaszdziurko.pages.clients.ClientsPage;
import pl.tomaszdziurko.pages.contact.ContactPage;
import pl.tomaszdziurko.pages.products.ProductOnePage;
import pl.tomaszdziurko.pages.products.ProductTwoPage;

public abstract class BasePage extends WebPage {

    public BasePage() {
        add(new NavBarPanel.Builder("navBar", HomePage.class, "Example Web App", getActiveMenu())
                .withMenuItem(MenuItemEnum.CLIENTS, ClientsPage.class)
                .withMenuItemAsDropdown(MenuItemEnum.PRODUCTS, ProductOnePage.class, "Product One")
                .withMenuItemAsDropdown(MenuItemEnum.PRODUCTS, ProductTwoPage.class, "Product Two")
                .withMenuItemAsDropdown(MenuItemEnum.PRODUCTS, ProductTwoPage.class, "Product Three")
                .withMenuItemAsDropdown(MenuItemEnum.ABOUT_US, TeamPage.class, "Team")
                .withMenuItemAsDropdown(MenuItemEnum.ABOUT_US, OurSkillsPage.class, "Our Skills")
                .withMenuItem(MenuItemEnum.CONTACT, ContactPage.class)
                .build());
    }

    public abstract MenuItemEnum getActiveMenu();
    
}
