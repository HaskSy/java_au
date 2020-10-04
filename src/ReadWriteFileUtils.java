import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWriteFileUtils {

    private static boolean isNotCreated(File file) {
        if (file.exists()) {
            return false;
        }
        System.out.printf("ERROR. File: %s is not located in this directory on doesn't exists\n", file.getName());
        return true;
    }

    private static boolean isReadable(File file) {
        if (!file.canRead()) {
            System.out.printf("ERROR. File: %s cannot be read\n", file.getName());
            return false;
        }
        return true;
    }

    private static boolean isEmpty(File file) {
        return file == null || file.length() == 0;
    }

    private static boolean isURL(String s) {
        return s.startsWith("https://");
    }

    private static String removeLastChar(String s) {
        return (s == null || s.length() == 0) ? null : (s.substring(0, s.length() - 1));
    }

    private static List<String> parseListString(List<String> file) {
        List<String> updatedFile = new ArrayList<>();
        for (String line : file) {
            if (line != null && line.length() != 0 && !line.equals("\n")) {
                while (line.endsWith(" ")) {
                    line = removeLastChar(line);
                }
                updatedFile.add(line);
            }
        }
        return updatedFile;
    }

    private static String[] listSolution(String s) {
        return s.split("\n");
    }

    private static ArrayList<String> splitTasks(File file) throws IOException {
        ArrayList<String> split = new ArrayList<>();
        BufferedReader splitter = new BufferedReader(new FileReader(file));
        int symbol = splitter.read();
        int openBrackets = 0;
        int closeBrackets = 0;
        StringBuilder Solution = new StringBuilder();
        while (symbol != -1) {
            Solution.append((char) symbol);
            if (symbol == (int) '{') {
                openBrackets++;
            } else if (symbol == (int) '}') closeBrackets++;
            if (openBrackets != 0) {
                if (openBrackets == closeBrackets) {
                    openBrackets = 0;
                    closeBrackets = 0;
                    split.add(Solution.toString());
                    Solution = new StringBuilder();
                }
            }
            symbol = splitter.read();
        }
        splitter.close();
        return split;

    }

    private static SolutionLeetcode setToSolutionLeetcodeClass(List<String> Solution) {
        SolutionLeetcode cl = new SolutionLeetcode();
        String title = null;
        String link;
        StringBuilder sourceCode = new StringBuilder();
        for (String s : Solution) {
            if (title == null) {
                title = s;
                cl.setTitle(title);
            } else if (isURL(s)) {
                link = s;
                cl.setLink(link);
            } else sourceCode.append(s).append('\n');

        }
        cl.setSourceCode(sourceCode.toString());
        return cl;
    }

    private static String getEndOfLink(String link) {
        return link.substring(30, link.length() - 1);
        // https://leetcode.com/problems/non-overlapping-intervals/
        // "https://leetcode.com/problems/".length() = 31
    }

    private static char toUpperCase(char c) {
        return (char) ((c >= 'a' && c <= 'z') ? (c + ('A' - 'a')) : c);
    }

    private static String setMainTitle(File file) {
        String MainTitle = file.getName();
        return toUpperCase(MainTitle.charAt(0)) + MainTitle.substring(1, MainTitle.length() - 3);
    }

    private static void initEmptyMd(SolutionLeetcode cl, File markdown) throws IOException {
        BufferedWriter writer = new BufferedWriter(new PrintWriter(markdown));
        writer.write("# " + setMainTitle(markdown) + "\n");
        writer.write("+ [" + cl.getTitle() + "](#" + getEndOfLink(cl.getLink()) + ")\n"); //+ [Non-overlapping Intervals](#non-overlapping-intervals)
        writer.write("## " + cl.getTitle() + "\n");
        writer.write(cl.getLink() + "\n");
        writer.write("```java\n");
        writer.write(cl.getSourceCode());
        writer.write("```\n");
        writer.close();
    }

    private static int getEndOfTitleLinks(File markdown) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(markdown.getPath()));
        String output = null;
        for (String s : lines) {
            if (output == null) {
                if (s.startsWith("+ [")) {
                    output = s;
                }
            } else {
                if (s.startsWith("+ [")) {
                    output = s;
                }
                else break;
            }
        }
        return lines.indexOf(output);

    }

    private static void appendToMd(SolutionLeetcode cl, File markdown) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(markdown.getPath()));
        lines.add(getEndOfTitleLinks(markdown) + 1, "+ [" + cl.getTitle() + "](#" + getEndOfLink(cl.getLink()) + ")");
        lines.add("## " + cl.getTitle());
        lines.add(cl.getLink());
        lines.add("```java");
        lines.add(cl.getSourceCode());
        lines.add("```");
        lines = parseListString(lines);
        BufferedWriter writer = new BufferedWriter(new FileWriter(markdown));
        for (String line : lines) {
            writer.write(line + '\n');
        }
        writer.close();
    }

    public static void txtToMarkdown(String txtPath, String markdownPath) throws IOException {
        File txtSolution = new File(txtPath);
        ArrayList<SolutionLeetcode> SolutionClasses = new ArrayList<>();
        if (isNotCreated(txtSolution)) return;
        if (isReadable(txtSolution)) {
            ArrayList<String> splitTasks = splitTasks(txtSolution);
            for (String s : splitTasks) {
                List<String> txt = Arrays.asList(listSolution(s));
                txt = parseListString(txt);
                SolutionClasses.add(setToSolutionLeetcodeClass(txt));
            }
            File markdown = new File(markdownPath);
            if (!markdown.exists()) markdown.createNewFile();
            if (isReadable(markdown)) {
                for (SolutionLeetcode cl : SolutionClasses) {
                    if (isEmpty(markdown)) {
                        initEmptyMd(cl, markdown);
                    } else {
                        appendToMd(cl, markdown);
                    }
                }
            }
        }
    }
}
