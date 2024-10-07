import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    /**
     * Sorts House Array by using PriorityQueueHeap
     * @param a House Array to be sorted.
     */
    public static void heapsort(House[] a) {
        PriorityQueueHeap pqh = new PriorityQueueHeap();

        for (House h : a){
            pqh.add(h);
        }

        int counter = 0;
        while(pqh.getLength() > 0){
            a[counter] = pqh.getMostExpensive();
            counter++;
        }
    }

    public static void main(String[] args) {

        House[] houseArry = new House[1000];

        File houseFile = new File("house.txt");

        try {
            //create a scanner object to read from the houseFile.
            Scanner sc = new Scanner(houseFile);

            int counter = 0;
            // Read and populate the priority queue list with the house objects.
            while (sc.hasNextLine()) {
                String name = sc.nextLine(); //read the next line and assign it to the name variable.
                int value = Integer.parseInt(sc.nextLine());
                House house = new House(name, value);

                houseArry[counter] = house;
                counter++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        heapsort(houseArry);


        for(House i : houseArry){
            System.out.println("Owner: {" + i.getOwner() + "}  Value: {" + i.getValue()+"}");
        }

        System.out.println("-------------------------------------");
        PriorityQueueHeap deepCopyTest = new PriorityQueueHeap();
        deepCopyTest.add(new House("Furkan", 999));
        deepCopyTest.add(new House("Hoskey", 1));

        PriorityQueueHeap deepCopyConstruct = new PriorityQueueHeap(deepCopyTest);

        PriorityQueueHeap deepCopyMethod;
        deepCopyMethod = deepCopyTest.deepCopy();


        while(!deepCopyTest.isEmpty()){
            System.out.println(deepCopyTest.getMostExpensive());
        }
        System.out.println("-------------------------------------");


        while(!deepCopyConstruct.isEmpty()){
            System.out.println(deepCopyConstruct.getMostExpensive());
        }
        System.out.println("-------------------------------------");


        while(!deepCopyMethod.isEmpty()){
            System.out.println(deepCopyMethod.getMostExpensive());
        }


    }
}