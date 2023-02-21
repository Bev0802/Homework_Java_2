import java.util.Arrays;
import java.util.logging.*;

// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

public class Task_02 {
    public static void main(String[] args) {
        int[] array = { 9, 10, 0, 5, 1, 3, 7 };
        System.out.println(Arrays.toString(array));
        bubbleSortAlgorithm (array);        
        System.out.println(Arrays.toString(array));               
    }

    private static void bubbleSortAlgorithm (int[] array) {
        //подготовка к логированию.
        Logger logfile = Logger.getGlobal();   
        try{
            FileHandler log = new FileHandler("log.txt");
            logfile.addHandler(log);
            SimpleFormatter txt = new SimpleFormatter();
          
            log.setFormatter(txt);                                
        }catch (Exception e){
            System.out.println("Erorr!");
        }
        //метод пузырька
        for (int size = array.length; size >= 0; size--) {
            for (int i = 0; i < size && i + 1 < size; i++){
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    //запись итерации в лог файл.
                    logfile.log (Level.INFO, String.format ("%d <-> %d, %s", array[i], array[i+1], Arrays.toString(array)));                                 
                }
            }
        }
    }
}



