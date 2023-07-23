//First Name: Chada
//Last Name: Bendriss
//Student nember: 300266679


import java.lang.Math;

public class Plane3D {
    private Point3D p1;
    private Point3D p2;
    private Point3D p3;
    private double a;
    private double b;
    private double c;
    private double d;

    //calcul de l'equation du plan grace aux points
    public Plane3D(Point3D p1, Point3D p2, Point3D p3){
        a=(p2.getY()-p1.getY())*(p3.getZ()-p1.getZ())-(p3.getY()-p1.getY())*(p2.getZ()-p1.getZ());
        b=(p2.getZ()-p1.getZ())*(p3.getX()-p1.getX())-(p3.getZ()-p1.getZ())*(p2.getX()-p1.getX());
        c=(p2.getX()-p1.getX())*(p3.getY()-p1.getY())-(p3.getX()-p1.getX())*(p2.getY()-p1.getY());
        d=-(a*p1.getX()+b*p1.getY()+c*p1.getZ());
    }
    //Constructeur
    public Plane3D(double a, double b, double c, double d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
    //Calcul la distance entre le point et le plan
    public double getDistance(Point3D pt){
        double n=Math.abs(a*pt.getX() +b*pt.getY() +c*pt.getZ() +d);
        double d=Math.sqrt(Math.pow(a, 2)+Math.pow(b,2)+Math.pow(c, 2));
        double r=n/d;
        return r;
    }
    //Retourne les valeurs des points
    public Point3D getp1(){
        return p1;
    }
    //Retourne les valeurs des points
    public Point3D getp2(){
        return p2;
    }
    //Retourne les valeurs des points
    public Point3D getp3(){
        return p3;
    }
}
