import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Tasks2 {
    /* 1. Теша шел по прямой улице, по обеим сторонам которой стояло ровно n
       одинаковых домов. Номера домов на улице выглядят так:
       1 | | 6
       3 | | 4
       5 | | 2
       Она заметила, что четные дома увеличиваются справа, а нечетные уменьшаются слева.
       Создайте функцию, которая принимает номер дома и длину улицы n и возвращает номер
       дома на противоположной стороне. */
    public static int oppositeHouse(int num, int streetLen) {
        if (num%2 == 0) {
            int i = 0;
            int subNum = 2*streetLen;
            while (subNum != num){
                subNum -= 2;
                i++;
            }
            return 2*i + 1;
        }
        else {
            int i = 1;
            int subNum = 2*streetLen - 1;
            while (subNum != num){
                subNum -= 2;
                i++;
            }
            return 2*i;
        }

    }

    /* 2. Создайте метод, который принимает строку (имя и фамилию человека) и
		возвращает строку с заменой имени и фамилии. */
    public static String nameShuffle(String name) {
        String[] words = name.split("\\s");
        return words[1] + " " + words[0];
    }

    /* 3. Создайте функцию, которая принимает два аргумента: исходную цену и процент
		скидки в виде целых чисел и возвращает конечную цену после скидки. */
    public static double discount(int price, int discount) {
        return price * (1 - (double)discount/100);
    }

    /* 4. Создайте функцию, которая принимает массив и возвращает разницу между
		наибольшим и наименьшим числами. */
    public static int differenceMaxMin(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] - nums[0];
    }

    /* 5. Создайте функцию, которая принимает три целочисленных аргумента (a, b, c) и
		возвращает количество целых чисел, имеющих одинаковое значение. */
    public static int equal(int a, int b, int c) {
        int[] nums = {a,b,c};
        int final_count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer count: map.values()){
            if (count > 1)
                final_count += count;
        }
        return final_count;
    }

    /* 6. Создайте метод, который принимает строку в качестве аргумента и возвращает ее в
		обратном порядке. */
    public static String reverse(String word) {
        StringBuilder strBuilder = new StringBuilder(word);
        return strBuilder.reverse().toString();
    }


    /* 7. Вы наняли трех программистов и (надеюсь) платите им. Создайте функцию,
		которая принимает три числа (почасовая заработная плата каждого программиста)
		и возвращает разницу между самым высокооплачиваемым программистом и самым
		низкооплачиваемым. */
    public static int programmers(int a, int b, int c) {
        int[] nums = {a,b,c};
        Arrays.sort(nums);
        return nums[2] - nums[0];

    }

    /* 8. Создайте функцию, которая принимает строку, проверяет, имеет ли она одинаковое
		количество x и o и возвращает либо true, либо false.
		Правила:
			- Возвращает логическое значение (true или false).
			- Верните true, если количество x и o одинаковы.
			- Верните false, если они не одинаковы.
			- Строка может содержать любой символ.
			- Если "x" и "o" отсутствуют в строке, верните true. */
    public static boolean getXO(String word) {
        word = word.toLowerCase();
        int count_x = 0;
        int count_o = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == 'x')
                count_x++;
            if (word.charAt(i) == 'o')
                count_o++;
        }
        return count_x == count_o;
    }

    /* 9. Напишите функцию, которая находит слово "бомба" в данной строке. Ответьте
		"DUCK!", если найдешь, в противном случае: "Relax, there's no bomb.". */
    public static String bomb(String str) {
        if (str.toLowerCase().contains("bomb"))
            return "DUCK!";
        else
            return "Relax, there's no bomb.";
    }

    /* 10. Возвращает true, если сумма значений ASCII первой строки совпадает с суммой
		значений ASCII второй строки, в противном случае возвращает false. */
    public static boolean sameAscii(String str1, String str2) {
        int str1_ascii = 0;
        int str2_ascii = 0;
        for (int i = 0; i < str1.length(); i++)
            str1_ascii += (int)str1.charAt(i);
        for (int i = 0; i < str2.length(); i++)
            str2_ascii += (int)str2.charAt(i);
        return str1_ascii == str2_ascii;
    }

    /* Проверка работы */
    public static void main(String[] args) {
        //1
        assert oppositeHouse(1, 3) == 6;
        assert oppositeHouse(2, 3) == 5;
        assert oppositeHouse(3, 5) == 8;
        assert oppositeHouse(5, 46) == 88;

        //2
        assert nameShuffle("Donald Trump").equals("Trump Donald");
        assert nameShuffle("Rosie O'Donnell").equals("O'Donnell Rosie");
        assert nameShuffle("Seymour Butts").equals("Butts Seymour");

        //3
        assert discount(1500, 50) == 750;
        assert discount(89, 20) == 71.2;
        assert discount(100, 75) == 25;

        //4
        assert differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}) == 82;
        // Smallest number is -50, biggest is 32.
        assert differenceMaxMin(new int[]{44, 32, 86, 19}) == 67;
        // Smallest number is 19, biggest is 86.

        //5
        assert equal(3, 4, 3) == 2;
        assert equal(1, 1, 1) == 3;
        assert equal(3, 4, 1) == 0;

        //6
        assert reverse("Hello World").equals("dlroW olleH");
        assert reverse("The quick brown fox.").equals(".xof nworb kciuq ehT");
        assert reverse("Edabit is really helpful!").equals("!lufpleh yllaer si tibadE");

        //7
        assert programmers(147, 33, 526) == 493;
        assert programmers(33, 72, 74) == 41;
        assert programmers(1, 5, 9) == 8;

        //8
        assert getXO("ooxx") == true;
        assert getXO("xooxx") == false;
        assert getXO("ooxXm") == true;
        // Case insensitive.
        assert getXO("zpzpzpp") == true;
        // Returns true if no x and o.
        assert getXO("zzoo") == false;

        //9
        assert bomb("There is a bomb.").equals("DUCK!");
        assert bomb("Hey, did you think there is a BOMB?").equals("DUCK!");
        assert bomb("This goes boom!!!").equals("Relax, there's no bomb.");

        //10
        assert sameAscii("a", "a") == true;
        assert sameAscii("AA", "B@") == true;
        assert sameAscii("EdAbIt", "EDABIT") == false;
    }
}
