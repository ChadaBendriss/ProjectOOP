//First Name: Chada
//Last Name: Bendriss
//Student nember: 300266679

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class PointCloud {
    public ArrayList<Point3D>nPoints;
    
    public PointCloud(String filename) {
        String path= filename;
        String line="";
        nPoints=new ArrayList<Point3D>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            //Permet d'ignorer la premiere ligne
             br.readLine();
            //Separer les points grace au tab puis les Stocker dans une liste
            while((line=br.readLine()) !=null ){
                String [] tab= line.split("\\s" );
                nPoints.add(new Point3D (Double.parseDouble(tab[0]),Double.parseDouble(tab[1]),Double.parseDouble(tab[2])));
            }
            //Fermet le fichier
            br.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("not read");
        }catch(IOException e){
            ;
        }
    }
    //Constructeur
    public PointCloud(){
        nPoints=new ArrayList<Point3D>();

    }
    //Retourne la liste
    public ArrayList<Point3D> getArray(){
         return nPoints;
    }
    //Ajouter le point à la liste
    public void addPoint(Point3D pt){
        nPoints.add(pt);
    }
    //Retourne un point au hasard
    public Point3D getPoint(){
        
        return nPoints.get((int)(Math.random() * nPoints.size()));

    }
    //Permet de sauvegarder les points dans un nouveau fichier
    public void save(String filename){
        try {
            //Ecrire dans le nouveau csv file
            FileWriter fw = new FileWriter(filename,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            //Ecriture des coordonnes du point avec tab comme separateur entre les coordonnées
            pw.println("x"+"\t"+"y"+"\t"+"z");
            
            for(int k=1;k<nPoints.size();k++){
                    
                    double X=nPoints.get(k).getX();
                    double Y=nPoints.get(k).getY();
                    double Z=nPoints.get(k).getZ();
                    pw.println(X+"\t"+Y+"\t"+Z+"\t");
                
            }
            //Fermer le fichier
            pw.flush();
            pw.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Not saved"); 
        }
    }
    //An iterator method that returns an iterator to the points in the cloud
    public Iterator<Point3D>iterator(){
       return nPoints.iterator();

	}
    //Enlever le point de la liste
    public void removePoint(Point3D pt) {
        nPoints.remove(pt);
    }
    //Taille de la liste
    public int size() {
        return nPoints.size();
    }
         
}
