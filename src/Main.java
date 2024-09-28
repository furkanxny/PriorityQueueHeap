public class Main {

    public static void heapsort(House[] a) {
        House[] houseArry = new House[a.length];

        int counter = 0;
        for (House h : a) {
            houseArry[counter] = h;
            counter++;
        }
    }

    public static void main(String[] args) {


        House house1 = new House("ow1", 90);
        House house2 = new House("ow2", 80);
        House house3 = new House("ow3", 45);
        House house4 = new House("ow4", 92);
        House house5 = new House("ow5", 50);
        House house6 = new House("ow5", 85);
        House house7 = new House("ow6", 30);
        House house8 = new House("ow7", 70);
        House house9 = new House("ow8", 60);
        House house10 = new House("ow9", 40);
        House house11 = new House("ow10", 20);
        House house12 = new House("ow11", 10);


        PriorityQueueHeap pqh = new PriorityQueueHeap();


        pqh.add(house1);
        pqh.add(house2);
        pqh.add(house3);
        pqh.add(house4);
        pqh.add(house5);
        pqh.add(house6);
        pqh.add(house7);
        pqh.add(house8);
        pqh.add(house9);
        pqh.add(house10);
        pqh.add(house11);
        pqh.add(house12);

//                    10
//                30      20
//             60   40   45 80
//           92 70 90 50 85

        PriorityQueueHeap newPQH = new PriorityQueueHeap(pqh);

        for (int i = 0; i < newPQH.getLength(); i++) {
            System.out.println("Owner: " + newPQH.getHouseArray()[i].getOwner() + " Value: " + newPQH.getHouseArray()[i].getValue());
        }


    }
}