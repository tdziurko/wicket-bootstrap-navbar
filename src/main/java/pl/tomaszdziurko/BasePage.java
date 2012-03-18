package pl.tomaszdziurko;

import org.apache.wicket.markup.html.WebPage;

public class BasePage extends WebPage {

    public BasePage() {
        add(new NavBarPanel("navBar"));
    }
    
}
