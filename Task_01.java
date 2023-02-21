//В файле содержится строка с исходными данными в такой форме:
//{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
//SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
//Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
import java.io.*;

public class Task_01{
    public static void main(String[] args) throws Exception { 
       //чтение из файла
        BufferedReader br = new BufferedReader(new FileReader("Task_01.txt"));
        String strfile = br.readLine();
        System.out.println(strfile);
        br.close();
        
        //обрезали фигурную скобку
        strfile = strfile.substring(1, strfile.length()-1);

       //создали StringBuilder, добавили туда нужную стоку.
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM students WHERE ");

       //из строки создали массив
        String[] parts = strfile.split (", ");
        
        for (String part : parts) {
           
            String[] keystringfile = part.split (":"); //создали массив из массива
            
            String key = keystringfile[0];
            key = key.substring (1, key.length() - 1); //обрзезали ковычки у наименования

            String stringfile = keystringfile[1];

            if (stringfile.equals("\"null\"")) // если значение не заполенено не выводить.
                continue; 

            builder.append (String.format ("%s = %s AND ", key, stringfile)); //выводим в строку наименовекние и заначение        

        }  
        System.out.println(builder.substring(0, builder.length()-4));   //вывод на печать с обрезанием последенго AND/   
    }  

}