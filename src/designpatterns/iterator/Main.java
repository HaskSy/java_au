package designpatterns.iterator;

public class Main {

    public static void main(String[] args) {
        Integer[][][] Array3d = {
                {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {null, null, null, null}},
                {{9, 9, 9, 9}, {9, 9, 9, 9}, {9, 9, 9, 9}, {null, null, null, 8}},
                {{8, 3, 5, 1}, {6, 6, 6, null}, {null, null, null, 12453}, {1, 2, 3, 4}}
        };
        Array3D<Integer> Iterable3dArray = new Array3D<>(Array3d);

        while (Iterable3dArray.hasNext()) {
            System.out.println(Iterable3dArray.next());
        }
    }
}
