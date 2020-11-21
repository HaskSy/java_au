package Triangles;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileParsing {

    public static List<Triangle> fileToTriangleList(File file) throws IOException {
        List<String> stringList = Files.readAllLines(Path.of(file.getPath()));
        return stringList.stream().map(Triangle::value).filter(Objects::nonNull).collect(Collectors.toList());

    }

    public static void writeInFile(List<Triangle> triangleList, File file) throws IOException {
        if (triangleList.isEmpty()) return;
        List<Triangle> IsoscelesTriangles = triangleList.stream().filter(Triangle::isIsosceles).collect(Collectors.toList());
        Triangle biggestTriangle = IsoscelesTriangles.stream().min(Comparator.comparing(Solution::getTriangleScale)).get();

        String triangle = biggestTriangle.toString() + "Scale: " + Solution.getTriangleScale(biggestTriangle);
        PrintWriter out = new PrintWriter(file.getPath());
        out.println(triangle);
        out.close();
    }
}
