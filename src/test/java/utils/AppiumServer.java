package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;

    public class AppiumServer {

        private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

        static void startAppiumServer() {
            service.start();
        }

        static void stopAppiumServer() {
            service.stop();
        }
    }
