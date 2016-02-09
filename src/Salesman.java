import java.applet.Applet;
import java.awt.Graphics;

import javax.xml.stream.events.StartDocument;


public class Salesman extends Applet {
	
	int numCities=5;
	double lowestDistance=10000;
	String hi="23014";
	String str = "12304";
	public int worldX=1000;
	public int worldY=1000;
	
	StringBuffer bestPath=new StringBuffer(hi);
	
	City [] cityList=new City[numCities];
	
	
	public void init(){
		for (int a=0;a<cityList.length;a++){
			int x= (int) (Math.random()*400);
			int y= (int) (Math.random()*400);
			cityList[a]=new City(x,y,"Boston"+a);	
		}
		for (int a=0;a<cityList.length;a++){
			System.out.println(a+":    "+cityList[a]);
		}
		findRoute();
		setSize(worldX,worldY);
		//System.out.println(distance(cityList[0], cityList[1]));
	}
	
	public void paint(Graphics g)
	   {   
		int startX=200;
		int startY=200;
		for (int a=0;a<cityList.length;a++){ 
		
		g.drawRect(cityList[a].x+startX, cityList[a].y+startY, 5, 5);
		g.drawString("City "+a,cityList[a].x-15+startX, cityList[a].y-5+startY);
		}
		
	   }
	
	public double distance(City a, City b){
		return(Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2)));
	}
	
	public double totalDistance(City a, City b, City c, City d, City e){
		return(distance(a, b)+distance(b, c)+distance(c,d)+distance(d,e)+distance(d,a));
		
	}
	public void findRoute(){
	    
	    
	    StringBuffer strBuf = new StringBuffer(str);
	    doPerm(strBuf,str.length());
	    System.out.println("lowest Distance:   "+lowestDistance);
	    //String finalBestPath;
	    char a=bestPath.charAt(bestPath.length()-5);
	    char b=bestPath.charAt(bestPath.length()-4);
	    char c=bestPath.charAt(bestPath.length()-3);
	    char d=bestPath.charAt(bestPath.length()-2);
	    char e=bestPath.charAt(bestPath.length()-1);
	    String bestPath="";
	    bestPath=bestPath+a+b+c+d+e;
	   // System.out.println("bestPath:  "+bestPath.charAt(bestPath.length()-5)+bestPath.charAt(bestPath.length()-4)+""+bestPath.charAt(bestPath.length()-3)+""+bestPath.charAt(bestPath.length()-2)+""+bestPath.charAt(bestPath.length()-1));
	    System.out.println(bestPath);
	}

	public void doPerm(StringBuffer str, int index){

	    if(index <= 0){
	        System.out.println(str);
	        double pathDistance=totalDistance(cityList[Integer.valueOf(str.charAt(0))-48], cityList[Integer.valueOf(str.charAt(1))-48], cityList[Integer.valueOf(str.charAt(2))-48],cityList[Integer.valueOf(str.charAt(3))-48],cityList[Integer.valueOf(str.charAt(4))-48]);
	        if (pathDistance<lowestDistance){
	        	lowestDistance=pathDistance;
	        	bestPath.append(str);
	        	
	        	
	        }
	        System.out.println("distance:  "+pathDistance);
	        System.out.println("**************************************");
	    }
	    else { //recursively solve this by placing all other chars at current first pos
	        doPerm(str, index-1);
	        int currPos = str.length()-index;
	        for (int i = currPos+1; i < str.length(); i++) {//start swapping all other chars with current first char
	            swap(str,currPos, i);
	            doPerm(str, index-1);
	            swap(str,i, currPos);//restore back my string buffer
	        }
	    }
	}

	public void swap(StringBuffer str, int pos1, int pos2){
	    char t1 = str.charAt(pos1);
	    str.setCharAt(pos1, str.charAt(pos2));
	    str.setCharAt(pos2, t1);
	} 
	
	
	}   



/*System.out.println("value of first character:  "+(Integer.valueOf(str.charAt(0))-48));
System.out.println("value of second character:  "+(Integer.valueOf(str.charAt(1))-48));
System.out.println("value of third character:  "+(Integer.valueOf(str.charAt(2))-48));*/
	
	


