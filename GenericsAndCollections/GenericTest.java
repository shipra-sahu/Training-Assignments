package assignment.day3.collections_generic;

class MyGen<T> implements Comparable<MyGen<T>>{  
T obj;
int value = 6;
public T getObj() {
	return obj;
}

public void setObj(T obj) {
	this.obj = obj;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	MyGen other = (MyGen) obj;
	if (this.obj == null) {
		if (other.obj != null)
			return false;
	} else if (!this.obj.equals(other.obj))
		return false;
	return true;
}


@Override
public int compareTo(MyGen<T> o) {
	if(this.value== o.value)
    	return 0;
	else if(this.value>o.value)
		return 1;
    else return -1;
}  
  
}  

public class GenericTest {

	public static void main(String[] args) {
		MyGen<Integer> m=new MyGen<Integer>();  
		m.setObj(2); 
		MyGen<Integer> n=new MyGen<Integer>();  
		n.setObj(3);
		if(m.equals(n)) {
			System.out.println("Equal");
		}
		else System.out.println("Not eQual ");
		
		//m.add("shipra");//Compile time error  
		System.out.println(m.getObj());  

	}

}
