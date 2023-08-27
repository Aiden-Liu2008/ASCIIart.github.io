import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class AsciiOpener {
    public static void main(String[] args) {
        String filePath = "art.html";
        openWebPage(filePath);
        openBlankPage();
    }

    public static void openWebPage(String filePath) {
        File htmlFile = new File(filePath);
        try {
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.err.println("File not found: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openBlankPage() {
        try {
            Desktop.getDesktop().browse(new java.net.URI("about:blank"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (java.net.URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
