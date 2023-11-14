package webshop.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperBase {
    protected WebDriverManager wdm;

    public HelperBase(WebDriverManager wdm) {this.wdm = wdm;}
}
