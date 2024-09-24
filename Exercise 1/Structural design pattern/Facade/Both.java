package Facade;

import java.util.ArrayList;

class Both implements Menus{
   public ArrayList<String> menu=new ArrayList<>();
   public Both(){
       menu.add("Paratha");
       menu.add("Chole Kulcha");
       menu.add("Veg.Pizza");
       menu.add("Mutton Korma");
       menu.add("Nihari Gosht");}
   public void getItems()
   {
       for(int i=0;i<menu.size();i++)
       {
           System.out.println(menu.get(i));
       }
   }
}
