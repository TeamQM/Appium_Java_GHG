package com.framework.goodhealthgateway.utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class FileUtil {

    public static String getLatestVideoFile() {
        try {
            String today = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            Path folderPath = Paths.get("Reports", "Videos", today);

            if (!Files.exists(folderPath)) {
                System.out.println("❌ No folder for today: " + folderPath);
                return null;
            }

            Optional<Path> latestFile = Files.list(folderPath)
                    .filter(Files::isRegularFile) // only files
                    .max(Comparator.comparingLong(f -> f.toFile().lastModified()));

            if (latestFile.isPresent()) {
                File file = latestFile.get().toFile();
                System.out.println("✅ Latest file: " + file.getAbsolutePath());
                return file.getAbsolutePath();
            } else {
                System.out.println("⚠️ No files found in today's folder: " + folderPath);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getLatestVideoFileForReport() {
        try {
            String videoFolderDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            Path videoFolderPath = Paths.get("Reports", "Videos", videoFolderDate);
            
            if (!Files.exists(videoFolderPath)) {
                System.out.println("❌ No video folder for today: " + videoFolderPath);
                return null;
            }
            
            Optional<Path> latestFile = Files.list(videoFolderPath)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().toLowerCase().endsWith(".mp4"))
                    .max(Comparator.comparingLong(f -> f.toFile().lastModified()));
            
            if (latestFile.isPresent()) {
                String fileName = latestFile.get().getFileName().toString();
                
         
                String relativePath = "../../Videos/" + videoFolderDate + "/" + fileName;
                
                System.out.println("✅ Latest video (relative): " + relativePath);
                return relativePath;
            } else {
                System.out.println("⚠️ No video files found in: " + videoFolderPath);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
//    public static void main(String[] args) {
//    	System.out.println(getLatestVideoFile());
//    	System.out.println(getLatestVideoFileForReport());
//    }
    //✅ Latest file: D:\GHEMobileAutomation\GHEMobileAutomation\Reports\Videos\04-09-2025\testLoginWithInvalidPassword_20250904_184842.mp4

}
