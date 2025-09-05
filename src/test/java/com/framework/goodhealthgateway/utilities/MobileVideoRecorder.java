package com.framework.goodhealthgateway.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import java.time.Duration;

public class MobileVideoRecorder {

    private final AppiumDriver driver;
    private final String dailyVideoPath;
    private String videoFileName;

    public MobileVideoRecorder(AppiumDriver driver) {
        this.driver = driver;
        this.dailyVideoPath = createDailyFolder();
    }

    private String createDailyFolder() {
        String dateFolder = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String dailyPath = System.getProperty("user.dir") + "/Reports/Videos/" + dateFolder + "/";
        
        File dailyDir = new File(dailyPath);
        if (!dailyDir.exists()) {
            dailyDir.mkdirs();
        }
        return dailyPath;
    }

    /**
     * Starts recording for individual test method
     */
    public void startTestRecording(String testName) {
        try {
            if (driver == null) {
                throw new IllegalStateException("AppiumDriver is not initialized. Cannot start test recording.");
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            videoFileName = testName + "_" + timestamp;
            
            String platformName = String.valueOf(driver.getCapabilities().getCapability("platformName"));
            
            if (platformName.equalsIgnoreCase("Android")) {
                startAndroidRecording();
            } else if (platformName.equalsIgnoreCase("iOS")) {
                startIOSRecording();
            } else {
                startBasicRecording();
            }
            
            System.out.println("Test recording started for " + platformName + ": " + videoFileName);
            
        } catch (Exception e) {
            System.err.println("Failed to start test recording: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void startAndroidRecording() {
        AndroidStartScreenRecordingOptions options = new AndroidStartScreenRecordingOptions()
            .withVideoSize("1280x720")
            .withBitRate(4000000)
            .withTimeLimit(Duration.ofMinutes(10)); // 10 minutes per test :cite[5]
        
        ((CanRecordScreen) driver).startRecordingScreen(options);
    }

    private void startIOSRecording() {
        IOSStartScreenRecordingOptions options = new IOSStartScreenRecordingOptions()
            .withVideoScale("1280:720")
            .withTimeLimit(Duration.ofMinutes(10)) // 10 minutes per test :cite[5]
            .withVideoQuality(IOSStartScreenRecordingOptions.VideoQuality.HIGH) // High quality :cite[9]
            .withFps(30); // 30 FPS for smooth recording :cite[9]
        
        ((CanRecordScreen) driver).startRecordingScreen(options);
    }

    private void startBasicRecording() {
        ((CanRecordScreen) driver).startRecordingScreen();
    }

    /**
     * Stops recording and saves the video for individual test method
     */
    public void stopTestRecording() {
        try {
            String base64Video = ((CanRecordScreen) driver).stopRecordingScreen();
            
            if (base64Video == null || base64Video.isEmpty()) {
                throw new IOException("Received empty video data from device");
            }
            
            byte[] data = Base64.getDecoder().decode(base64Video);

            // Save the video file
            String filePath = dailyVideoPath + videoFileName + ".mp4";
            try (FileOutputStream stream = new FileOutputStream(filePath)) {
                stream.write(data);
            }
            
            System.out.println("Test video successfully saved at: " + filePath);
            System.out.println("Video size: " + (data.length / (1024 * 1024)) + " MB");
            
        } catch (Exception e) {
            System.err.println("Failed to stop/save test recording: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getVideoFilePath() {
        return dailyVideoPath + videoFileName + ".mp4";
    }
}