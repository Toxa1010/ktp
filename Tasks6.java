package com.company;
import java.util.*;
public class Tasks6 {
    /* 1. Создайте функцию, которая принимает две строки. Первая строка содержит
       предложение, содержащее буквы второй строки в последовательной
       последовательности, но в другом порядке. Скрытая анаграмма должна содержать
       все буквы, включая дубликаты, из второй строки в любом порядке и не должна
       содержать никаких других букв алфавита.
       Напишите функцию, чтобы найти анаграмму второй строки, вложенную где-то в
       первую строку. Вы должны игнорировать регистр символов, любые пробелы и
       знаки препинания и возвращать анаграмму в виде строчной строки без пробелов
       или знаков препинания.
       Примечание:
       - Совершенная анаграмма содержит все буквы оригинала в любом порядке, ни
       больше, ни меньше.
       - Если в предложении нет скрытой анаграммы, верните "noutfond".
       - Как и в приведенных выше примерах, скрытая анаграмма может начинаться или
       заканчиваться частично через слово и/или охватывать несколько слов и может
       содержать знаки препинания и другие не-альфа-символы.
       - Игнорируйте регистр символов и любые встроенные не-альфа-символы.
       - Если в предложении больше 1 результата, верните ближайший к началу. */

    public static int[] getLetterSet(String str) {
        int[] set = new int[26];
        for (char c : str.toCharArray())
            set[c - 97]++;
        return set;
    }

    public static String onlyLetters(String str) {
        str = str.toLowerCase();
        String res = "";
        for (char c : str.toCharArray())
            if (97 <= c && c <= 122)
                res += c;
        return res;
    }

    public static String hiddenAnagram(String a, String b) {
        a = onlyLetters(a);
        b = onlyLetters(b);
        int[] setB = getLetterSet(b);
        for (int i = 0; i <= a.length() - b.length(); i++) {
            String substr = a.substring(i, i+b.length());
            int[] setA = getLetterSet(substr);
            if (Arrays.equals(setA, setB)) {
                String res = "";
                for (char c : substr.toCharArray())
                    if (97 <= c && c <= 122)
                        res += c;
                return res;
            }
        }
        return "noutfond";
    }

    /* 2. Напишите функцию, которая возвращает массив строк, заполненных из срезов
       символов n-длины данного слова (срез за другим, в то время как n-длина
       применяется к слову).
       Примечания:
       - Убедитесь, что результирующий массив лексикографически упорядочен.
       - Возвращает пустой массив, если заданная строка меньше n.
       - Ожидается, что вы решите эту задачу с помощью рекурсивного подхода. */

    public static String[] collect(String s, int n) {
        if (s.length() < n)
            return new String[] {};
        String[] res = collect(s.substring(n), n);
        String head = s.substring(0, n);
        String[] newRes = new String[res.length+1];
        int index = 0;
        while (index < res.length && res[index].compareTo(head) < 0) index++;
        System.arraycopy(res, 0, newRes, 0, index);
        System.arraycopy(res, index, newRes, index+1, res.length - index);
        newRes[index] = head;
        return newRes;
    }

    /* 3. В шифре Nico кодирование осуществляется путем создания цифрового ключа и
       присвоения каждой буквенной позиции сообщения с помощью предоставленного
       ключа.
       Создайте функцию, которая принимает два аргумента, message и key, и возвращает
       закодированное сообщение.
       Существуют некоторые вариации правил шифрования. Одна из версий правил
       шифрования изложена ниже:
       message = "mubashirhassan"
       key = "crazy"
       nicoCipher(message, key) ➞ "bmusarhiahass n"
       Шаг 1: Назначьте числа отсортированным буквам из ключа:
       "crazy" = 23154
       Шаг 2: Назначьте номера буквам данного сообщения:
        2 3 1 5 4
        ---------
        m u b a s
        h i r h a
        s s a n
       Шаг 3: Сортировка столбцов по назначенным номерам:
        1 2 3 4 5
        ---------
        b m u s a
        r h i a h
        a s s   n
       Шаг 4: Верните закодированное сообщение по строкам:
       eMessage = "bmusarhiahass n" */

    public static int[] getCharset(String word) {
        int[] charset = new int[127];
        for (char c : word.toCharArray()) charset[c]++;
        return charset;
    }

    public static String nicoCipher(String message, String key) {
        for (int i = 0; i < (message.length()+key.length()) % key.length(); i++)
            message += ' ';
        int[] set = getCharset(key);
        int[] setCount = set.clone();
        int counter = 1;
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0) {
                if (set[i] > 1)
                    counter += set[i] - 1;
                set[i] = counter++;
            }
        int[] offsets = new int[key.length()];
        for (int i = 0; i < key.length(); i++)
            offsets[set[key.charAt(i)]-setCount[key.charAt(i)]--] = i;
        String res = "";
        for (int i = 0; i < message.length(); i++) {
            int index = (i / offsets.length) * offsets.length + offsets[i % offsets.length];
            res += message.charAt(index);
        }

        return res;
    }

    /* 4. Создайте метод, который принимает массив arr и число n и возвращает массив из
       двух целых чисел из arr, произведение которых равно числу n следующего вида:
       [value_at_lower_index, value_at_higher_index]
       Убедитесь, что вы возвращаете массив из двух целых чисел, который точно делит n
       (произведение n) и что индексы совпадают с указанным выше форматом. Таким образом,
       сортировка значений основана на восходящих индексах.
       Примечание:
       - Дубликатов не будет.
       - Возвращает пустой массив, если совпадение не найдено.
       - Всегда считайте, что пара рассматриваемого элемента (текущий элемент, на который
       указывали во время поиска) находится слева от него.
       - Массив может иметь несколько решений (произведений n), поэтому возвращайте первое
       найденное полное совпадение (как описано выше). */

    public static int[] twoProduct(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int m : arr) {
            if (n % m == 0 && set.contains(n / m))
                return new int[] {n/m, m};
            set.add(m);
        }
        return new int[] {};
    }

    /* 5. Создайте рекурсивную функцию, которая проверяет, является ли число точной
       верхней границей факториала n. Если это так, верните массив точной
       факториальной границы и n, или иначе, пустой массив.
       Примечание:
       - Ожидается, что вы решите эту задачу с помощью рекурсии. */

    public static int[] isExact(int f, int m, int n) {
        if (f < n)
            return isExact(f*(m+1), m+1, n);
        return new int[] {f, m};
    }

    public static int[] isExact(int n) {
        int[] res = isExact(1, 1, n);
        if (res[0] == n) return res;
        return new int[] {};
    }

    /* 6. Деление на дробь часто приводит к бесконечно повторяющейся десятичной дроби.
       1/3=.3333333... 1/7=.142857142857...
       Создайте функцию, которая принимает десятичную дробь в строковой форме с
       повторяющейся частью в круглых скобках и возвращает эквивалентную дробь в
       строковой форме и в наименьших членах. */

    public static String fractions(String frac) {
        int startBracket = frac.indexOf('(');
        if (startBracket != -1) {
            String f = frac.substring(startBracket+1, frac.length()-1);
            frac = frac.substring(0, startBracket);
            for (int i = 0; i < 9 - f.length(); i++)
                frac += f;
        }
        double a = Double.parseDouble(frac);
        int div = 2;
        while (Math.ceil(a * div) - a * div > 0.000001) div++;
        return "" + (int)Math.ceil(a * div) + "/" + div;
    }

    /* 7. В этой задаче преобразуйте строку в серию слов (или последовательности
       символов), разделенных одним пробелом, причем каждое слово имеет одинаковую
       длину, заданную первыми 15 цифрами десятичного представления числа Пи:
       3.14159265358979
       Если строка содержит больше символов, чем общее количество, заданное суммой цифр
       Пи, неиспользуемые символы отбрасываются, и вы будете использовать только те,
       которые необходимы для формирования 15 слов.
       String =
       "HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMME
       CHANICSANDALLTHESECRETSOFTHEUNIVERSE"
       Pi String = "HOW I NEED A DRINK ALCOHOLIC IN NATURE AFTER THE HEAVY
       LECTURES INVOLVING QUANTUM MECHANICS"
       // Every word has the same length of the digit of Pi found at the same
       index ?
       // "HOW" = 3, "I" = 1, "NEED" = 4, "A" = 1, "DRINK" = 5
       // "ALCOHOLIC" = 9, "IN" = 2, "NATURE" = 6, "AFTER" = 5
       // "THE" = 3, "HEAVY" = 5, "LECTURES" = 8, "INVOLVING" = 9
       // "QUANTUM" = 7, "MECHANICS" = 9
       // 3.14159265358979
       Также, если строка содержит меньше символов, чем общее количество, заданное суммой
       цифр Пи, в любом случае вы должны соблюдать последовательность цифр для получения
       слов.
       String = "FORALOOP"
       Pi String = "FOR A LOOP"
       // Every word has the same length of the digit of Pi found at the same
       index ?
       // "FOR" = 3, "A" = 1, "LOOP" = 4
       // 3.14
       Если буквы, содержащиеся в строке, не совпадают в точности с цифрами, в этом случае
       вы будете повторять последнюю букву, пока слово не будет иметь правильную длину.
       String = "CANIMAKEAGUESSNOW"
       Pi String = "CAN I MAKE A GUESS NOWWWWWWW"
       // Every word has the same length of the digit of Pi found at the same
       index ?
       // "CAN" = 3, "I" = 1, "MAKE" = 4, "A" = 1, "GUESS" = 5, "NOW" = 3
       // 3.14153 (Wrong!)
       // The length of the sixth word "NOW" (3)...
       // ...doesn't match the sixth digit of Pi (9)
       // The last letter "W" will be repeated...
       // ...until the length of the word will match the digit
       // "CAN" = 3, "I" = 1, "MAKE" = 4, "A" = 1, "GUESS" = 5, "NOWWWWWWW" =
       9
       // 3.14159 (Correct!)
       Если данная строка пуста, должна быть возвращена пустая строка.
       Учитывая строку txt, реализуйте функцию, которая возвращает ту же строку,
       отформатированную в соответствии с приведенными выше инструкциями.
       Примечание:
       - Эта задача представляет собой упрощенную концепцию, вдохновленную Пилишем,
       своеобразным типом ограниченного письма, в котором используются все известные
       возможные цифры Пи. Потенциально бесконечный текст может быть написан с
       использованием знаков препинания и набора дополнительных правил, которые позволяют
       избежать длинных последовательностей маленьких цифр, заменяя их словами больше 9
       букв и делая так, чтобы композиция выглядела более похожей на стихотворение вольным
       стихом.
       - Точка, отделяющая целую часть числа Пи от десятичной, не должна учитываться в
       функции: она присутствует в инструкциях и примерах только для удобства чтения. */


    public static String pilish_string(String str) {
        String res = "";
        String pi = String.valueOf(Math.PI).replace(".", "");
        int piIndex = 0;
        while (str.length() > 0) {
            int p = pi.charAt(piIndex) - 48;
            int n = Math.min(p, str.length());
            res += str.substring(0, n);
            str = str.substring(n);
            piIndex++;
            if (str.length() > 0) res += ' ';
            else if (p > n)
                for (int i = 0; i < p - n; i++)
                    res += res.charAt(res.length() - 1);
        }
        return res;
    }

    /* 8. Создайте функцию для генерации всех непоследовательных двоичных строк, где
       непоследовательные определяется как строка, в которой нет последовательных
       строк, и где n определяет длину каждой двоичной строки. */

    public static String generateNonconsecutive(int n) {
        String res = "";
        String format = "%" + n + 's';
        int count = 2 << (n-1);
        nextNumber:
        for (int i = 0; i < count; i++) {
            String num = String.format(format, Integer.toBinaryString(i)).replace(' ', '0');
            for (int j = 0; j < n - 1; j++)
                if (num.charAt(j) == '1' && num.charAt(j+1) == '1')
                    continue nextNumber;
            res += num + ' ';
        }
        return res.substring(0, res.length() - 1);
    }

    /* 9. Шерлок считает строку действительной, если все символы строки встречаются
       одинаковое количество раз. Также допустимо, если он может удалить только 1
       символ из 1 индекса в строке, а остальные символы будут встречаться одинаковое
       количество раз. Для данной строки str определите, действительна ли она. Если да,
       верните «ДА», в противном случае верните «НЕТ».
       Например, если str = "abc", строка действительна, потому что частота символов у всех
       одинакова. Если str = "abcc", строка также действительна, потому что мы можем
       удалить 1 "c" и оставить по одному символу каждого символа в строке. Однако, если
       str = "abccc", строка недействительна, поскольку удаление одного символа не приводит
       к одинаковой частоте символов. */

    public static String isValid(String str) {
        int[] set = getLetterSet(str);
        int[] medium = new int[str.length()];
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0) medium[set[i]]++;
        int cur = 0;
        int max = 0;
        for (int i = 0; i < medium.length; i++)
            if (medium[i] > cur) {
                cur = medium[i];
                max = i;
            }
        boolean index = false;
        for (int i = 0; i < set.length; i++)
            if (set[i] != 0 && max - set[i] != 0) {
                if (index) return "NO";
                index = true;
            }
        return "YES";
    }

    /* 10. Создайте функцию, которая получает каждую пару чисел из массива, который
       суммирует до восьми, и возвращает его как массив пар (отсортированный по
       возрастанию). */

    public static int[][] sumsUp(int[] arr) {
        ArrayList<int[]> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(8 - arr[i])) {
                int a = arr[i];
                int b = 8 - a;
                if (a > b) {
                    b = a;
                    a = 8 - b;
                }
                res.add(new int[] {i - map.get(8-arr[i]), a, b});
            }
            map.put(arr[i], i);
        }
        Collections.sort(res, (o1, o2) -> o1[0]-o2[0]);
        int[][] newRes = new int[res.size()][];
        for (int i = 0; i < res.size(); i++)
            newRes[i] = new int[] {res.get(i)[1], res.get(i)[2]};
        return newRes;
    }
    /* Проверка работы */
    public static void main(String[] args) {
        assert hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived").equals("worldevolvesin");
        // The sequence "world evolves in" is a perfect anagram of "sworn love lived".
        assert hiddenAnagram("An old west action hero actor", "Clint Eastwood").equals("noldwestactio");
        // The sequence "n old west actio" is a perfect anagram of "Clint Eastwood".
        assert hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison").equals("mrmojorisin");
        // The sequence "Mr. Mojo Risin" ignoring the full stop, is a perfect
        // anagram of "Jim Morrison".
        assert hiddenAnagram("Banana? margaritas", "ANAGRAM").equals("anamarg");
        // The sequence "ana? marg" ignoring "?" is a perfect anagram of "Anagram".
        assert hiddenAnagram("D e b90it->?$ (c)a r...d,,#~", "bad credit").equals("debitcard");
        // When all spaces, numbers and puntuation marks are removed
        // from the whole phrase, the remaining characters form the sequence
        // "Debitcard" which is a perfect anagram of "bad credit".
        assert hiddenAnagram("Bright is the moon", "Bongo mirth").equals("noutfond");
        // The words "Bright moon" are an anagram of "bongo mirth" but they are
        // not a continuous alphabetical sequence because the words "is the" are in
        // between. Hence the negative result, "noutfond" is returned.

        assert Arrays.equals(
                collect("intercontinentalisationalism", 6),
                new String[] {"ationa", "interc", "ntalis", "ontine"}
        );
        assert Arrays.equals(
                collect("strengths", 3),
                new String[] {"eng", "str", "ths"}
        );
        assert Arrays.equals(
                collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15),
                new String[] {"croscopicsilico", "pneumonoultrami", "volcanoconiosis"}
        );

        assert nicoCipher("myworldevolvesinhers", "tesh").equals("yowmledrovlvsnieesrh");
        assert nicoCipher("andiloveherso", "tesha").equals("lnidaevheo s or");
        assert nicoCipher("mubashirhassan", "crazy").equals("bmusarhiahass n");
        assert nicoCipher("edabitisamazing", "matt").equals("deabtiismaaznig ");
        assert nicoCipher("iloveher", "612345").equals("lovehir    e");

        assert Arrays.equals(
                twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15, 3}, 45),
                new int[] {9, 5}
        );
        // at index 5 which has the value 5 is a full match
        // to the value at index 3 which is 9
        // the closest gap between indices that equates
        // to the product which is 45
        assert Arrays.equals(
                twoProduct(new int[] {1, 2, 3, 9, 4, 15, 3, 5}, 45),
                new int[] {3, 15}
        );
        // at index 5 which has the value 15 is a full match
        // to the value at index 2 which is 3
        // the closest gap between indices that equates
        // to the product which is 45
        assert Arrays.equals(
                twoProduct(new int[] {1, 2, -1, 4, 5, 6, 10, 7}, 20),
                new int[] {4, 5}
        );
        // at index 4 which has the value 5 is a full match
        // to the value at index 3 which is 4
        // a full match can only be achieved if you've found the multiplier at an
        // index lower than the current index, thus, 5 (@ index 4) has a pair lower
        // than its index which is the value 4 (@ index 3), so, 5*4 = 20, in which 5
        // has a higher index (4) than 4 which has an index value of 3
        assert Arrays.equals(
                twoProduct(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10),
                new int[] {2, 5}
        );
        assert Arrays.equals(
                twoProduct(new int[] {100, 12, 4, 1, 2}, 15),
                new int[] {}
        );

        assert Arrays.equals(
                isExact(6),
                new int[] {6, 3}
        );
        assert Arrays.equals(
                isExact(24),
                new int[] {24, 4}
        );
        assert Arrays.equals(
                isExact(125),
                new int[] {}
        );
        assert Arrays.equals(
                isExact(720),
                new int[] {720, 6}
        );
        assert Arrays.equals(
                isExact(1024),
                new int[] {}
        );
        assert Arrays.equals(
                isExact(40320),
                new int[] {40320, 8}
        );

        assert fractions("0.(6)").equals("2/3");
        assert fractions("1.(1)").equals("10/9");
        assert fractions("3.(142857)").equals("22/7");
        assert fractions("0.19(2367)").equals("5343/27775");
        assert fractions("0.1097(3)").equals("823/7500");

        assert pilish_string("33314444").equals("333 1 4444");
        // 3.14
        assert pilish_string("TOP").equals("TOP");
        // 3
        assert pilish_string("X").equals("XXX");
        // "X" has to match the same length of the first digit (3)
        // The last letter of the word is repeated
        assert pilish_string("").equals("");

        assert generateNonconsecutive(1).equals("0 1");
        assert generateNonconsecutive(2).equals("00 01 10");
        assert generateNonconsecutive(3).equals("000 001 010 100 101");
        assert generateNonconsecutive(4).equals("0000 0001 0010 0100 0101 1000 1001 1010");

        assert isValid("aabbcd").equals("NO");
        // We would need to remove two characters, both c and d -> aabb or a and b -> abcd, to make it valid.
        // We are limited to removing only one character, so it is invalid.
        assert isValid("aabbccddeefghi").equals("NO");
        // Frequency counts for the letters are as follows:
        // {"a": 2, "b": 2, "c": 2, "d": 2, "e": 2, "f": 1, "g": 1, "h": 1, "i": 1}
        // There are two ways to make the valid string:
        // Remove 4 characters with a frequency of 1: {f, g, h, i}.
        // Remove 5 characters of frequency 2: {a, b, c, d, e}.
        // Neither of these is an option.
        assert isValid("abcdefghhgfedecba").equals("YES");
        // All characters occur twice except for e which occurs 3 times.
        // We can delete one instance of e to have a valid string.

        assert Arrays.deepEquals(
                sumsUp(new int[] {1, 2, 3, 4, 5}),
                new int[][] {{3, 5}}
        );
        assert Arrays.deepEquals(
                sumsUp(new int[] {1, 2, 3, 7, 9}),
                new int[][] {{1, 7}}
        );
        assert Arrays.deepEquals(
                sumsUp(new int[] {10, 9, 7, 2, 8}),
                new int[][] {}
        );
        assert Arrays.deepEquals(
                sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7}),
                new int[][] {{2, 6}, {3, 5}, {1, 7}}
        );
        // [6, 2] first to complete the cycle (to sum up to 8)
        // [5, 3] follows
        // [1, 7] lastly
        // the pair that completes the cycle is always found on the left
        // [2, 6], [3, 5], [1, 7] sorted according to cycle completeness, then pair-wise.
    }
}
