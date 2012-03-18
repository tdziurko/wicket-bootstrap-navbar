package pl.tomaszdziurko;

import org.apache.wicket.protocol.http.WebApplication;
import pl.tomaszdziurko.pages.HomePage;
import pl.tomaszdziurko.pages.aboutus.OurSkillsPage;
import pl.tomaszdziurko.pages.aboutus.TeamPage;
import pl.tomaszdziurko.pages.clients.ClientsPage;
import pl.tomaszdziurko.pages.contact.ContactPage;
import pl.tomaszdziurko.pages.products.ProductOnePage;
import pl.tomaszdziurko.pages.products.ProductThreePage;
import pl.tomaszdziurko.pages.products.ProductTwoPage;

public class WicketApplication extends WebApplication {

    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }

    @Override
    public void init() {
        mountPage("clients", ClientsPage.class);
        mountPage("product-one", ProductOnePage.class);
        mountPage("product-two", ProductTwoPage.class);
        mountPage("product-three", ProductThreePage.class);
        mountPage("team", TeamPage.class);
        mountPage("skills", OurSkillsPage.class);
        mountPage("contact", ContactPage.class);

        getMarkupSettings().setStripWicketTags(true);
        setExternalHtmlDirIfSystemPropertyIsPresent();
    }

    private void setExternalHtmlDirIfSystemPropertyIsPresent() {
        String externalDir = System.getProperty("wicket.html.dir");
        if (externalDir != null) {
            getResourceSettings().addResourceFolder(externalDir);
        }
    }
}
