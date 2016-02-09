
public class City {
	int x;
	int y;
	String name;
	int position=1;
	
	public City(int px,int py,String pname ) {
		name=pname;
		x=px;
		y=py;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
	      String temp="";
	      
	         temp+="x:  "+x+" ";
	         temp+="y:  "+y+" ";
	         temp+=name;
	         
	      return temp;
	   
	   }

}
