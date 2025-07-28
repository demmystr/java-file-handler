package app;

public class Main {

    private final static String BASE_PATH = "files/";

    /**
     * Main method to run the file handling example.
     */
    public static void main(String[] args) {

        if (!isBasePathExists()) {
            createBasePath();
        }

        FileHandler handler = new FileHandler();
        String fileName = "myfile";
        String filePath = BASE_PATH + fileName + ".txt";
        String fileContent = "My very important information.";
        String result = handler.writeFile(filePath, fileContent);
        String content = handler.readFile(filePath);
        getOutput("RESULT: " + result);
        getOutput("FILE CONTENT: " + content);
    }

    private static boolean isBasePathExists() {
        java.io.File basePath = new java.io.File(BASE_PATH);
        return basePath.exists() && basePath.isDirectory();
    }

    private static void createBasePath() {
        try {
            java.io.File basePath = new java.io.File(BASE_PATH);
            if (!basePath.exists()) {
                boolean success = basePath.mkdir();
                if(!success) {
                    throw new RuntimeException("Unable to create directory");
                }
            }
        } catch (Exception e) {
            getOutput("Error creating base path: " + e.getMessage());
        }
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}