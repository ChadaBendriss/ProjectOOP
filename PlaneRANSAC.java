//First Name: Chada
//Last Name: Bendriss
//Student nember: 300266679
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PlaneRANSAC {
    private double eps;
    private PointCloud pc;

    public PlaneRANSAC(PointCloud pc){
        this.pc=pc;
        this.eps=0.1;

    }
    //Setter methode pour changer la valeur de eps
    public void setEps(double eps){
        this.eps=eps;

    }
    //Acceder a la valeur de eps
    public double getEps(){
        return eps;
    }

    //Calcul le nombre d'iterations
    public int getNumberOfIterations(double confidence, double percentageOfPointsOnPlane){
        int k=(int) (Math.log(1-confidence)/Math.log(1-Math.pow(percentageOfPointsOnPlane, 3)));
        return k;
    }
    public void run(int numberOfIterations,String filename){
       
            //Initialement, aucun plan n’a été trouvé et le meilleur support est fixé à 0 
            int bs=0;
            Plane3D bp=null;
            boolean isDone=false;
            int l=0;
            while(!isDone){
                //Sélectionner aléatoirement 3 points à l’intérieur du nuage de points
                Point3D p1 = pc.getPoint();
                Point3D p2 = pc.getPoint();
                Point3D p3 = pc.getPoint();
                
                //Calculer l’équation du plan défini par ces trois points
                Plane3D plane = new Plane3D(p1, p2, p3);
                int support = 0;

                Iterator<Point3D> iterator = pc.iterator();
                while (iterator.hasNext()) {
                    //Compter le nombre de points situés à une distance inférieure à eps (ε) de ce plan. Ce nombre est le support pour le plan courant
                    
                    if (plane.getDistance(iterator.next()) < eps) {
                        support=support+1;
                    }
                }
                //Si le support courant est supérieur au meilleur support trouvé, alors le plan courant devient le plan dominant et son support est le nouveau meilleur support trouvé

                if (support > bs) {
                    bs = support;
                    bp = plane;
                }
                l++;
                if(l==numberOfIterations){
                    isDone=true;
                }

            }
            //enlever tous les points du nuage appartenant au plan dominant. Sauvegader ces points dans un fichier
           
            PointCloud dominantplaneponts=new PointCloud();
            Iterator<Point3D>it=pc.iterator();
            while(it.hasNext()){
                Point3D point = it.next();
                if(bp.getDistance(point)<eps){
                    dominantplaneponts.addPoint(point);
                    it.remove();
                }
            }
            //Sauvegarder le plan dominant dans un nouveau fichier
            dominantplaneponts.save(filename);
        
        //pc.save(filename + "Final.xyz"); 
    }
    public static void main(String[] args) {
        System.out.println("Enter the file name without <.xyz> (example: PointCloud1 ): ");
        Scanner file = new Scanner(System.in);
        String FileName = file.nextLine();
        //Pour le fichier
        PointCloud pointCloud = new PointCloud(FileName+".xyz");
        PlaneRANSAC ransac = new PlaneRANSAC(pointCloud);
        ransac.run(ransac.getNumberOfIterations(0.99, 0.05), FileName+"_p1.xyz");
        // Créer un nouvel objet PointCloud à partir des points restants
        PointCloud remainingPoints = new PointCloud();
        Iterator<Point3D> iterator = pointCloud.iterator();
                while (iterator.hasNext()) {
                    Point3D point = iterator.next();
                    remainingPoints.addPoint(point);
        }
        
        // Exécutez à nouveau RANSAC sur les points restants pour trouver le deuxième plan dominant
        PlaneRANSAC ransac2 = new PlaneRANSAC(remainingPoints);
        ransac2.run(ransac2.getNumberOfIterations(0.99, 0.05), FileName+"_p2.xyz");
   
        // Créer un nouvel objet PointCloud à partir des points restants
        PointCloud remainingPoints2 = new PointCloud();
        Iterator<Point3D> iterator2 = remainingPoints.iterator();
                while (iterator2.hasNext()) {
                    Point3D point2 = iterator2.next();
                    remainingPoints2.addPoint(point2);
        }
        // Exécutez à nouveau RANSAC sur les points restants pour trouver le deuxième plan dominant
        PlaneRANSAC ransac3 = new PlaneRANSAC(remainingPoints2);
        ransac2.run(ransac3.getNumberOfIterations(0.99, 0.05), FileName+"_p3.xyz");
        remainingPoints2.save( FileName+"_p0.xyz"); 


    }




}

