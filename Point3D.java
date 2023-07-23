//First Name: Chada
//Last Name: Bendriss
//Student nember: 300266679


public class Point3D {

    //Initialisation des variables tout en les mettant privés
    
    private double x;
    private double  y;
    private double  z;

    //Permet de recevoir les coordonnes du point
    public Point3D(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    //Donne acces au coordonné x
    public double getX(){
        return x;

    }
    //Donne acces au coordonné y
    public double getY(){
        return y;

    }
    //Donne acces au coordonné z
    public double getZ(){
        return z;

    }

    
}
