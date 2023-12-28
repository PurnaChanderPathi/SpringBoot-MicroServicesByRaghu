package Encapsulation;

public class Student {

 private int rollNumber;
 private String name;
 private boolean isAttended ;

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public int getRollNumber() {
	return rollNumber;
}

public void setRollNumber(int rollNumber) {
	this.rollNumber = rollNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isAttended() {
	return isAttended;
}

public void setAttended(boolean isAttended) {
	this.isAttended = isAttended;
}

public Student(int rollNumber) {
	super();
	this.rollNumber = rollNumber;
}

}
