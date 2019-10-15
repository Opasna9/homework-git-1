package conspect;

public class CreateArray {
    int myArray[];
    int mySecond[] = new int[100];
    int a[] = {5, 10, 0, -5, 16, -2};

    public static void main(String[] args) {
        int[] price = new int[10];
        int[] rooms = new int[]{1, 2, 3};
        Item[] undefinedItems = new Item[]{new Item(1), new Item(2), new Item(3)};

        int twoDim[][] = new int[4][];
        twoDim[0] = new int[10];
        twoDim[1] = new int[20];
        twoDim[2] = new int[30];
        twoDim[3] = new int[100];

        int arr[][] = {
                {1},
                {2, 3},
                {4, 5}
        };

        int ia[][] = {{1,2}, null};
        int ja[][] = (int[][]) ia.clone();
    }
}

class Item {
    public Item(int i) {

    }
}
