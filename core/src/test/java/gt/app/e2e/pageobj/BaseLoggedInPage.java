package gt.app.e2e.pageobj;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseLoggedInPage<U extends BaseLoggedInPage> extends BasePage<BaseLoggedInPage> {

    public UserPage openUserPage() {
        $("#user-article-link").click();
        return new UserPage();
    }

    public AdminPage openAdminPage() {
        $("#admin-area-link").click();
        return new AdminPage();
    }

    public PublicPage logout() {
        $("#logout-link").click();
        return new PublicPage();
    }

}