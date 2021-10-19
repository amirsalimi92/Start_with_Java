package com.company;

public class Main {

    public static void main(String[] args) {

        int[] aArray = new int[20];
        int[] bArray = new int[20];

        for (int i = 0; i < aArray.length; i++) {
            aArray[i] = (int) Math.pow(2, i + 1);
        }

        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = i + 1;
        }

        printArray(aArray);
        printArray(bArray);

        printArray(insertAt(aArray, 99, 3));
        printArray(interWeave(aArray, bArray));
    }

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder(array.length * 8);
        sb.append("{ ");
        for (int i : array) {
            sb.append(i).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2); // letztes Komma löschen
        sb.append("}\r\n");
        System.out.println(sb.toString());
    }


    public static int[] insertAt(int[] array, int value, int spot) {
        int[] result = new int[array.length + 1];
        // AUFGABENSTELLUNG 1:
        // Gib das Array result zurück, das alle Werte von array enthalten soll und zusätzlich an der Stelle "spot" den Wert "value";
        // z.B.:
        // 	array = { 0, 1, 2, 3 }
        //	value = 99
        // 	spot = 1
        // 	result = { 0, 99, 1, 2, 3 }
        int p= array.length;
        for (int i=0; i<spot; i++){
            result[i]=array[i];
        }

        for(int i=spot; i<=p; i++){
            result[i]=array[i-1];
        }
        result[spot]=value;
        return result;
    }

    public static int[] interWeave(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        // AUFGABENSTELLUNG 2:
        // result soll abwechselnd mit Werten von first und second befüllt und zurückgegeben werden. Benutze dazu die Methode insertAt.
        // z.B.:
        // 	first = { 1, 3, 5, 7 }
        // 	second = { 8, 10, 12, 14 }
        // 	result = { 1, 8, 3, 10, 5, 12, 7, 14 }
        int j=0;
        for(int i=0; i< result.length; i +=2){
            result[i]=first[i/2];
            result[i+1]=second[i/2];
            j++;
        }
        return result;

    }
}
