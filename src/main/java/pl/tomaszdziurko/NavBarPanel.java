package pl.tomaszdziurko;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import pl.tomaszdziurko.pages.HomePage;
import pl.tomaszdziurko.pages.aboutus.OurSkillsPage;
import pl.tomaszdziurko.pages.aboutus.TeamPage;
import pl.tomaszdziurko.pages.clients.ClientsPage;
import pl.tomaszdziurko.pages.contact.ContactPage;
import pl.tomaszdziurko.pages.products.ProductOnePage;
import pl.tomaszdziurko.pages.products.ProductThreePage;
import pl.tomaszdziurko.pages.products.ProductTwoPage;

public class NavBarPanel extends Panel {

    public NavBarPanel(String id) {
        super(id);
        
        add(new BookmarkablePageLink<BasePage>("homePage", HomePage.class));
        add(new BookmarkablePageLink<BasePage>("clientsPage", ClientsPage.class));
        add(new BookmarkablePageLink<BasePage>("productOnePage", ProductOnePage.class));
        add(new BookmarkablePageLink<BasePage>("productTwoPage", ProductTwoPage.class));
        add(new BookmarkablePageLink<BasePage>("productThreePage", ProductThreePage.class));
        add(new BookmarkablePageLink<BasePage>("teamPage", TeamPage.class));
        add(new BookmarkablePageLink<BasePage>("skillsPage", OurSkillsPage.class));
        add(new BookmarkablePageLink<BasePage>("contactPage", ContactPage.class));
    }
}
