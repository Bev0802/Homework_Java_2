import java.io.BufferedReader;
import java.io.FileReader;

//В файле содержится строка с данными:
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

public class Task_03 {
    public static void main(String[] args) throws Exception {
       
        //чтение из файла
        BufferedReader fileimput = new BufferedReader(new FileReader("Task_03.txt"));
        String data = fileimput.readLine();
        System.out.printf("\n%s\n", data);
        fileimput.close();
        
        data = crop(data);  // убрали []

        String[] students = data.split (", "); // создала массив, записала туда данные из строки по ", "
        
        for (String student : students) { // цикл по массиву
            student = crop(student);            // убираем фигурные
           
            String[] keyValues = student.split (",");
           
            String name = "", grade = "", subject = ""; // вспомогательные переменные
            System.out.printf("\n%s\n", student);

            for (String keyValue : keyValues) {
                String[] keyValueParts = keyValue.split (":");

                String key = crop (keyValueParts[0]); // за запись в ключь и переменную, обрзею ковычки.
                String value = crop (keyValueParts[1]);
                // раскладываем данные по переменным в зависимости от имени ключа
                if (key.equals ("фамилия"))
                    name = value;
                else if (key.equals ("оценка"))
                    grade = value;
                else if (key.equals ("предмет"))
                    subject = value;
                else 
                    throw new IllegalStateException("Поле не известно");
            }
            //Вывод на печать.
            System.out.printf(String.format("Студент %s получил %s по предмету %s. \n", name, grade, subject));
        }
    }
        //метод для обрезания начало и конца стоки.
        public static String crop (String str) {
            return str.substring(1, str.length()-1);            
        }    
}
