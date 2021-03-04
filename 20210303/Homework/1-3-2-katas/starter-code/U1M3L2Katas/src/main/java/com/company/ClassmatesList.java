package com.company;

import java.util.ArrayList;

public class ClassmatesList{
   private ArrayList<Classmate> classmate = new ArrayList<Classmate>();
   public void add(Classmate x){
       classmate.add(x);
   }
   public Classmate get(int x){
      return classmate.get(x);
   }
   public ArrayList<Classmate> getAll(){
     return classmate;
   }
}
