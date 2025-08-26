package com.framework.goodhealthgateway.drivermanager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.framework.goodhealthgateway.utilities.ConfigReader;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
public class AppiumServer {
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;
    public  void startServer () {
        cap = new DesiredCapabilities();
        builder = new AppiumServiceBuilder ();

        builder.withIPAddress ("127.0.0.1")
                .usingPort (4723)
                .withCapabilities(cap)
                .withArgument (() -> "--base-path", "/wd/hub")
                .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument (GeneralServerFlag.LOG_LEVEL, "debug");

        AppiumDriverLocalService  service = AppiumDriverLocalService.buildService(builder);
        service.start ();
        System.out.println("Server Started");

    }

    public void stopServer() {
        try {
            service.stop();
        } catch (Exception e) {
            System.err.println("Something went wrong when stopping server: " + e.getMessage());
        }
    }
    public boolean isServerRunning() {
        try {
            URL serverUrl = new URL(ConfigReader.getAppiumProp("serverIP") + "/wd/hub");
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return true;

            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    public boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
    public static void main(String[] args) {
        AppiumServer appiumServerJava = new AppiumServer();
        appiumServerJava.isServerRunning();
    }
}
