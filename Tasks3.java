import java.util.Arrays;

public class Tasks3 {
    /* 1. Учитывая массив городов и населения, верните массив, в котором все население
        округлено до ближайшего миллиона. */
    public static Object[][] millionsRounding(Object[][] arr) {
        for (int i = 0; i < arr.length; i++){
            double rounded = Math.round((double)(int)arr[i][1]/1000000)*1000000;
            Integer roundedInt = Integer.valueOf((int)rounded);
            arr[i][1] = roundedInt;
        }
        return arr;
    }

    /* 2. Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
        найти другие 2 стороны (верните самую длинную сторону, сторону средней
        длины). */
    public static double[] otherSides(double smallest) {
        double[] sides = new double[2];
        sides[0] = Math.round(2 * smallest * 100)/100.0;
        sides[1] = Math.round(Math.sqrt(3) * smallest * 100)/100.0;
        return sides;
    }

    /* 3. Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция
        принимает входные данные обоих игроков (камень, ножницы или бумага), первый
        параметр от первого игрока, второй от второго игрока. Функция возвращает
        результат как таковой:
            "Игрок 1 выигрывает"
            "Игрок 2 выигрывает"
            "НИЧЬЯ" (если оба входа одинаковы)
        Правила игры камень, ножницы, бумага, если не известны:
        Оба игрока должны сказать одновременно "камень", "бумага" или "ножницы".
        Камень бьет ножницы, бумага бьет камень, ножницы бьют бумагу. */
    public static String rps(String plr1, String plr2) {
        if (plr1.equals(plr2))
            return "TIE";
        if (plr1.equals("rock") && plr2.equals("scissors")
                || plr1.equals("paper") && plr2.equals("rock")
                || plr1.equals("scissors") && plr2.equals("paper"))
            return "Player 1 wins";
        else
            return "Player 2 wins";
    }

    /* 4. Идет великая война между четными и нечетными числами. Многие уже погибли в
        этой войне, и ваша задача-положить этому конец. Вы должны определить, какая
        группа суммируется больше: четная или нечетная. Выигрывает большая группа.
        Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные
        числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел. */
    public static int warOfNumbers(int[] nums) {
        int even_sum = 0;
        int odd_sum = 0;
        for (int num: nums){
            if (num%2 == 0)
                even_sum += num;
            else
                odd_sum += num;
        }
        return Math.abs(even_sum - odd_sum);
    }

    /* 5. Учитывая строку, создайте функцию для обратного обращения. Все буквы в
        нижнем регистре должны быть прописными, и наоборот. */
    public static String reverseCase(String str) {
        char[] charArray = str.toCharArray();

        for (int i=0; i < charArray.length; i++){
            if ( Character.isUpperCase(charArray[i]) )
                charArray[i] = Character.toLowerCase( charArray[i] );
            else if (Character.isLowerCase(charArray[i]) )
                charArray[i] = Character.toUpperCase( charArray[i] );
        }
        return new String(charArray);
    }

    /* 6. Создайте функцию, которая принимает строку из одного слова и выполняет
        следующие действия:
        Конкатенирует inator до конца, если слово заканчивается согласным, в противном
        случае вместо него конкатенирует -inator
        Добавляет длину слова исходного слова в конец, снабженный '000'. */
    public static String inatorInator(String word) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int strLen = word.length();
        StringBuilder strBuilder = new StringBuilder(word);
        if (consonants.contains(Character.toString(word.charAt(strLen-1))))
            strBuilder.append("inator ");
        else
            strBuilder.append("-inator ");
        strBuilder.append(strLen);
        strBuilder.append("000");
        return strBuilder.toString();
    }


    /* 7. Напишите функцию, которая принимает три измерения кирпича: высоту(a),
        ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
        отверстие с шириной(w) и высотой(h).
         */
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a*b <= w*h) || (a*c <= w*h) || (b*c <= w*h);
    }

    /* 8. Напишите функцию, которая принимает топливо (литры), расход топлива
        (литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
        максимальное расстояние, которое может проехать автомобиль.
        топливо-это количество литров топлива в топливном баке.
        Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
        Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
        Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на
        10%. */
    public static double totalDistance(double fuel, double fuel_cons, int passengers, boolean fan) {
        fuel_cons *= (1+0.05*passengers);
        if (fan)
            fuel_cons *= 1.1;
        return Math.round(fuel/fuel_cons*10000.0)/100.0;
    }

    /* 9. Создайте функцию, которая принимает массив чисел и возвращает среднее
        значение (average) всех этих чисел. */
    public static double mean(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num: nums) {
            sum += num;
            count++;
        }
        return Math.round((double)sum/count*100.0)/100.0;
    }

    /* 10. Создайте функцию, которая принимает число в качестве входных данных и
        возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
        противном случае верните false. */
    public static boolean parityAnalysis(int num) {
        int sum = 0;
        int num_ = num;
        while(num_>0){
            sum += num_%10;
            num_ /= 10;
        }
        return sum%2 == num%2;
    }

    /* Проверка работы */
    public static void main(String[] args) {
        //1
        Object[][] testArr = {{"Nice", 942208},{"Abu Dhabi", 1482816},{"Naples", 2186853},{"Vatican City", 572}};
        Object[][] expectedRes = {{"Nice", 1000000},{"Abu Dhabi", 1000000},{"Naples", 2000000},{"Vatican City", 0}};
        Object[][] res = millionsRounding(testArr);
        for (int i = 0; i < expectedRes.length; i++)
            assert (int)res[i][1] == (int)expectedRes[i][1];

        Object[][] testArr2 = {{"Manila", 13923452},{"Kuala Lumpur", 7996830},{"Jakarta", 10770487}};
        Object[][] expectedRes2 = {{"Manila", 14000000},{"Kuala Lumpur", 8000000},{"Jakarta", 11000000}};
        Object[][] res2 = millionsRounding(testArr2);
        for (int i = 0; i < expectedRes2.length; i++)
            assert (int)res2[i][1] == (int)expectedRes2[i][1];

        //2
        assert  Arrays.equals(otherSides(1), new double[]{2.0, 1.73});
        assert  Arrays.equals(otherSides(2), new double[]{4.0, 3.46});
        assert  Arrays.equals(otherSides(3), new double[]{6.0, 5.2});

        //3
        assert rps("rock", "paper").equals("Player 2 wins");
        assert rps("paper", "rock").equals("Player 1 wins");
        assert rps("paper", "scissors").equals("Player 2 wins");
        assert rps("scissors", "scissors").equals("TIE");
        assert rps("scissors", "paper").equals("Player 1 wins");

        //4
        assert warOfNumbers(new int[]{2, 8, 7, 5}) == 2;
        // 2 + 8 = 10
        // 7 + 5 = 12
        // 12 is larger than 10
        // So we return 12 - 10 = 2
        assert warOfNumbers(new int[]{12, 90, 75}) == 27;
        assert warOfNumbers(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}) == 168;

        //5
        assert reverseCase("Happy Birthday").equals("hAPPY bIRTHDAY");
        assert reverseCase("MANY THANKS").equals("many thanks");
        assert reverseCase("sPoNtAnEoUs").equals("SpOnTaNeOuS");

        //6
        assert inatorInator("Shrink").equals("Shrinkinator 6000");
        assert inatorInator("Doom").equals("Doominator 4000");
        assert inatorInator("EvilClone").equals("EvilClone-inator 9000");

        //7
        assert doesBrickFit(1, 1, 1, 1, 1) == true;
        assert doesBrickFit(1, 2, 1, 1, 1) == true;
        assert doesBrickFit(1, 2, 2, 1, 1) == false;

        //8
        assert totalDistance(70.0, 7.0, 0, false) == 1000.0;
        assert totalDistance(36.1, 8.6, 3, true) == 331.83;
        assert totalDistance(55.5, 5.5, 5, false) == 807.27;

        //9
        assert mean(new int[]{1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}) == 2.55;
        assert mean(new int[]{2, 3, 2, 3}) == 2.5;
        assert mean(new int[]{3, 3, 3, 3, 3}) == 3.0;

        //10
        assert parityAnalysis(243) == true;
        // 243 is odd and so is 9 (2 + 4 + 3)
        assert parityAnalysis(12) == false;
        // 12 is even but 3 is odd (1 + 2)
        assert parityAnalysis(3) == true;
        // 3 is odd and 3 is odd and 3 is odd (3)
    }
}
