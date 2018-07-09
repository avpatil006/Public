package journolDev;

public class outer{
	
private int a;
 private String name="visu";


private int getA() {
	return a;
}
private void setA(int a) {
	this.a = a;
}
public String getName() {
	return name;
} 
public void setName(String name) {
	this.name = name;
}

	public static void main(String[] args) {
		outer o=new outer();
		o.setA(12);
		o.setName("sunil");
		
		System.out.println(o.getA());
		
		
	}
}