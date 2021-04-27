public class Tasks1 {
    /* 1. Напишите функцию, которая принимает целое число минут и преобразует его в
      секунды. */
    public static int convert(int minutes) {
        return minutes * 60 ;
    }

    /* 2. Вы подсчитываете очки за баскетбольный матч, учитывая количество забитых 2-х
      и 3-х очков, находите окончательные очки для команды и возвращаете это
      значение. */
    public static double points(int p2, int p3) {
        return p2 * 2 + p3 * 3;
    }

    /* 3. Создайте функцию, которая принимает количество побед, ничьих и поражений и
      вычисляет количество очков, набранных футбольной командой на данный момент.
        выигрыш – получают 3 очка
        ничья – получают 1 очко
        проигрыш – получают 0 очков */
    public static int footballPoints(int win, int draw, int defeat) {
        return win*3 + draw*1;
    }

    /* 4. Создайте функцию, которая возвращает true, если целое число равномерно делится
      на 5, и false в противном случае. */
    public static boolean divisibleByFive(int num) {
        return num%5 == 0;
    }

    /* 5. В Java есть логический оператор &&. Оператор && принимает два логических
      значения и возвращает true, если оба значения истинны.
      Создайте функцию с помощью оператора &&. */
    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    /* 6. У меня есть ведро с большим количеством темно-синей краски, и я хотел бы
      покрасить как можно больше стен. Создайте функцию, которая возвращает
      количество полных стен, которые я могу покрасить, прежде чем мне нужно будет
      отправиться в магазины, чтобы купить еще.
        n - это количество квадратных метров, которые я могу нарисовать.
        w и h-это ширина и высота одной стены в метрах. */
    public static int howManyWalls(int n, int w, int h) {
        return n / (w * h);
    }


    /* 7. Поправьте код, чтобы решить эту задачу (только синтаксические ошибки)
      Посмотрите на приведенные ниже примеры, чтобы получить представление о том,
      что должна делать эта функция.
      Код:
        public class Challenge {
          public static int squaed(int b) {
            return a * a
          }
        } */
    public static int squared(int a) {
        return a * a;
    }

    /* 8. Создайте функцию, которая принимает три аргумента prob, prize, pay и возвращает
      true, если prob * prize > pay; в противном случае возвращает false. */
    public static boolean profitableGamble(double prob, double prize, double pay) {
        if (prob * prize > pay)
            return true;
        else
            return false;
    }

    /* 9. Создайте метод, который возвращает количество кадров, показанных за заданное
      количество минут для определенного FPS. */
    public static int frames(int fps, int minutes) {
        return fps * minutes * 60;
    }

    /* 10. Создайте функцию, которая будет работать как оператор модуля % без
      использования оператора модуля. Оператор модуля-это способ определения
      остатка операции деления. Вместо того чтобы возвращать результат деления,
      операция по модулю возвращает остаток целого числа. */
    public static int mod(int dividend, int divisor) {
        return (dividend - divisor * (dividend / divisor));
    }

    /* Проверка работы */
    public static void main(String[] args) {
        //1
        assert convert(5) == 300;
        assert convert(3) == 180;
        assert convert(2) == 120;

        //2
        assert points(13, 12) == 62;
        assert points(17, 12) == 70;
        assert points(38, 8) == 100;

        //3
        assert footballPoints(3, 4, 2) == 13;
        assert footballPoints(5, 0, 2) == 15;
        assert footballPoints(0, 0, 1) == 0;

        //4
        assert divisibleByFive(5) == true;
        assert divisibleByFive(-55) == true;
        assert divisibleByFive(37) == false;

        //5
        assert and(true, false) == false;
        assert and(true, true) == true;
        assert and(false, true) == false;
        assert and(false, false) == false;

        //6
        assert howManyWalls(54, 1, 43) == 1;
        assert howManyWalls(46, 5, 4) == 2;
        assert howManyWalls(100, 4, 5) == 5;
        assert howManyWalls(10, 15, 12) == 0;
        assert howManyWalls(41, 3, 6) == 2;

        //7
        assert squared(5) == 25;
        assert squared(9) == 81;
        assert squared(100) == 10000;

        //8
        assert profitableGamble(0.2, 50, 9) == true;
        assert profitableGamble(0.9, 1, 2) == false;
        assert profitableGamble(0.9, 3, 2) == true;

        //9
        assert frames(1, 1) == 60;
        assert frames(10, 1) == 600;
        assert frames(10, 25) == 15000;

        //10
        assert mod(5, 2) == 1;
        assert mod(218, 5) == 3;
        assert mod(6, 3) == 0;
    }
}
