import java.lang.Math;
public class Point3d {
    //Координата x
    private double xCoord;

    //Координата y
    private double yCoord;

    //Координата z
    private double zCoord;

    //Конструктор
    public Point3d ( double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    //Конструктор по умолчанию
    public Point3d () {
        this(0, 0, 0);
    }

    //Возвращение координаты x
    public double getX () {
        return xCoord;
    }

    //Возвращение координаты y
    public double getY () {
        return yCoord;
    }

    //Возвращение координаты z
    public double getZ () {
        return zCoord;
    }

    //Установка значения координаты x
    public void setX (double val) {
        xCoord = val;
    }

    //Установка значения координаты y
    public void setY (double val) {
        yCoord = val;
    }

    //Установка значения координаты z
    public void setZ (double val) {
        zCoord = val;
    }

    //Проверка равенства двух точек (равны, если равны соответствующие координаты)
    public boolean equalsTo(Point3d point){
        if (this.getX() == point.getX())
            if (this.getY() == point.getY())
                if (this.getZ() == point.getZ())
                    return true;
        return false;
    }

    //Вычисление расстояния между двумя точками (длина вектора)
    public double distanceTo(Point3d point){
        double d = Math.sqrt(Math.pow(this.getX() - point.getX(), 2)
                + Math.pow(this.getY() - point.getY(), 2)
                + Math.pow(this.getZ() - point.getZ(), 2));
        return Math.round(d * 100)/100.0;
    }
}

