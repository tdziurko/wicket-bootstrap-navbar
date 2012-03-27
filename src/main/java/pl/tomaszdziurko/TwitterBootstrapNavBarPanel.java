package pl.tomaszdziurko;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

import java.io.Serializable;
import java.util.Collection;

public class TwitterBootstrapNavBarPanel extends Panel {

    private TwitterBootstrapNavBarPanel(final Builder builder) {
        super(builder.id);

        BookmarkablePageLink<Void> homePageLink = new BookmarkablePageLink<Void>("homePageLink", builder.homePage);
        homePageLink.add(new Label("label", builder.applicationName));
        add(homePageLink);

        RepeatingView repeatingView = new RepeatingView("menuItems");

        for (MenuItemEnum item : builder.linksMap.keySet()) {
            boolean shouldBeActive = item.equals(builder.activeMenuItem);

            Collection<BookmarkablePageLink<?>> linksInThisMenuItem = builder.linksMap.get(item);

            if (linksInThisMenuItem.size() == 1) {
                BookmarkablePageLink<?> pageLink = Iterables.get(linksInThisMenuItem, 0);

                MenuLinkItem menuLinkItem = new MenuLinkItem(repeatingView.newChildId(), pageLink, shouldBeActive);
                repeatingView.add(menuLinkItem);
            } else {
                repeatingView.add(new MenuDropdownItem(repeatingView.newChildId(), item, linksInThisMenuItem,
                        shouldBeActive));
            }
        }

        add(repeatingView);
    }

    public static class Builder implements Serializable {

        private String id;
        private Class<? extends Page> homePage;
        private String applicationName;
        private MenuItemEnum activeMenuItem;

        private Multimap<MenuItemEnum, BookmarkablePageLink<?>> linksMap = LinkedHashMultimap.create();

        public Builder(String id, Class<? extends Page> homePage, String applicationName,
                       MenuItemEnum activeMenuItem) {
            this.id = id;
            this.homePage = homePage;
            this.applicationName = applicationName;
            this.activeMenuItem = activeMenuItem;
        }

        public Builder withMenuItem(MenuItemEnum menuItem, Class<? extends Page> pageToLink) {
            Preconditions.checkState(linksMap.containsKey(menuItem) == false, "Builder already contains " + menuItem +
                    ". Please use withMenuItemInDropdown if you need many links in one menu item");
            BookmarkablePageLink<Page> link = new BookmarkablePageLink<Page>("link", pageToLink);
            link.setBody(new Model<String>(menuItem.getLabel()));
            linksMap.put(menuItem, link);
            return this;
        }

        public Builder withMenuItemAsDropdown(MenuItemEnum menuItem, Class<? extends Page> pageToLink, String label) {
            BookmarkablePageLink<Page> link = new BookmarkablePageLink<Page>("link", pageToLink);
            link.setBody(new Model<String>(label));
            linksMap.put(menuItem, link);
            return this;
        }

        public TwitterBootstrapNavBarPanel build() {
            return new TwitterBootstrapNavBarPanel(this);
        }
    }
}
