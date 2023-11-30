package webshop.appmanager;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("app.conf");
    }
}
