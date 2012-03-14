package pl.tomaszdziurko;

import org.apache.wicket.markup.html.WebPage;

/**
 * TODO Update javadoc for this class
 */
public class BasePage extends WebPage {

    public BasePage() {
        add(new NavBarPanel("navBar"));
    }
    
}
