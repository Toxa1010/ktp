import java.util.Scanner;
public class Lr2 {
    public static void main(String[] args) {
        //Создаем 3 точки
        Point3d point1 = createPoint();
        Point3d point2 = createPoint();
        Point3d point3 = createPoint();
        //Проверяем, есть ли одинаковые точки, если нет, то выводим площадь треугольника
        if (point1.equalsTo(point2) || point1.equalsTo(point3) || point2.equalsTo(point3))
            System.out.println("Некоторые точки совпадают, невозможно вычислить площадь треугольника");
        else
            System.out.println(computeArea(point1, point2, point3));
    }

    //Получение введеных пользователем значений для точки и возвращение объекта класса Point3d
    public static Point3d createPoint(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        String input = scanner.nextLine();
        String[] xyz = input.split("\\s");
        double x = Double.parseDouble(xyz[0]);
        double y = Double.parseDouble(xyz[1]);
        double z = Double.parseDouble(xyz[2]);
        return new Point3d(x, y, z);
    }

    //Вычисление площади треугольника по 3 точкам
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        double ab = p1.distanceTo(p2);
        double bc = p2.distanceTo(p3);
        double ca = p3.distanceTo(p1);
        double p = (ab + bc + ca)/2;
        double s = Math.sqrt(p*(p-ab)*(p-bc)*(p-ca));
        return Math.round(s * 100)/100.0;
    }
}
