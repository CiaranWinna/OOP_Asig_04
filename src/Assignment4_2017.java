/**
 *
 * Student name: Ciaran Winnan	
 * Student number: 2940836
 */

public class Assignment4_2017 {
  public static void main(String[] args) {
     Student stud1 = new Student ("John", "294083648", "M", "8447748595", "English");
  	 Lecturer lect1 = new Lecturer ("Kim", "475938373", "F", "38375005", "Science");
  	 ///////////////////////////////QUESTION 1//////////////////////////////////////
  	 ///////////////////////////////STUDENT TEST////////////////////////////////////
  	 //Name test for Student
  	 String stud1Name = stud1.getName();
  	 System.out.println(stud1Name);
  	 //Number test for Student
  	 String stud1Number = stud1.getNumber();
  	 System.out.println(stud1Number);
  	 //Gender test for Student
  	 String stud1Gender = stud1.getGender();
  	 System.out.println(stud1Gender);
  	 //studentNumber test for Student
  	 String stud1SNumber = stud1.getStudentNumber();
  	 System.out.println(stud1SNumber);
  	 //studentSubject test for Student
  	 String stud1Subject = stud1.getSubject();
  	 System.out.println(stud1Subject);
  	 //toString test for Student
  	 String stud1ToString = stud1.toString();
  	 System.out.println(stud1ToString);
  	 ////////////////////////////////LECTURER TEST//////////////////////////////
  	 String lect1Name = lect1.getName();
  	 System.out.println("\n" + lect1Name);
  	 //Number test for Student
  	 String lect1Number = lect1.getNumber();
  	 System.out.println(lect1Number);
  	 //Gender test for Student
  	 String lect1Gender = lect1.getGender();
  	 System.out.println(lect1Gender);
  	 //studentNumber test for Student
  	 String lect1SNumber = lect1.getStaffNumber();
  	 System.out.println(stud1SNumber);
  	 //studentSubject test for Student
  	 String lect1Departemnt = lect1.getDepartment();
  	 System.out.println(lect1Departemnt);
  	 //toString test for Student
  	 String lect1ToString = lect1.toString();
  	 System.out.println(lect1ToString);
  	 
  	 ///////////////////////////QUESTION 2///////////////////////////////////
  	 Lecturers lec = new Lecturers(10);
  	 lec.addLecturer(lect1);
  	 
  	 //Passing new lecturers to class
  	 Lecturer lect2 = new Lecturer ("Matt", "675938373", "M", "48375005", "Math");
  	 lec.addLecturer(lect2);
  	 Lecturer lect3 = new Lecturer ("Sophie", "175938373", "F", "88375005", "Technology");
  	 lec.addLecturer(lect3);
  	 
  	 //Retrieve all lecturers with given gender
  	 Lecturer[] dataGender = lec.getLecturersGender();
  	 System.out.println("\nFemale:\n");
  	 for(int i = 0; i < dataGender.length; i++){
  	 	System.out.println(dataGender[i]);
  	 }
  	 
  	 //Deaprtment test
  	 String departmentTest =  "Technology";
  	 Lecturer[] lecDepartment = lec.lecturerDepartment(departmentTest);
  	 System.out.println("\nTechnology Department:\n");
  	 for(int i = 0; i < lecDepartment.length; i++){
  	 	System.out.println(lecDepartment[i]);
  	 }
  	 
  	 //Staff number test
  	 String searchStaffNumber = "48375005";
  	 Lecturer[] lecNumberSearch = lec.staffNumberSearch(searchStaffNumber);
  	 System.out.println("\nStaff Number Search:\n");
  	 for(int i = 0; i < lecNumberSearch.length; i++){
  	 	System.out.println(lecNumberSearch[i]);
  	 }
  	 
  	 //toString test
  	 String stringTest = lec.toString();
  	 System.out.println("\nString test: " + stringTest);
  	 
  	 //Size test
  	 int arraySize = lec.size();
  	 System.out.println("\nArray size: " + arraySize);
  }
}
//Q1 classes ==================================================
class Person{
	private String name;
	private String number;
	private String gender;
	
	public Person(String n, String num, String g){
		name = n;
		number = num;
		gender = g;
	}
	
	public String getName(){
		return name;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String toString(){
		return name + " " + number + " " + gender;
	}

}

class Student extends Person{
	private String studentNumber;
	private String subject;
	
	public Student(String n, String num, String g, String sn, String sub){
		super(n, num, g);
		studentNumber = sn;
		subject = sub;
	} 
	
	public String getStudentNumber(){
		return studentNumber;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public String toString(){
		return super.toString() + " " + studentNumber + " " + subject;
	}
}

class Lecturer extends Person{
	private String staffNumber;
	private String department;
	
	public Lecturer(String n, String num, String g, String sn, String d){
		super(n, num, g);
		staffNumber = sn;
		department = d;
	}
	
	public String getStaffNumber(){
		return staffNumber;
	}
	
	public String getDepartment(){
		return department;	
	}
	
	public String toString(){
		return super.toString() + " " + staffNumber + " " + department;
	}
	
}

//Q2 class ====================================================
class Lecturers{
	private Lecturer[] data;
	private int size;
	public Lecturers(int n){
		data = new Lecturer[n];
		size = 0;
	}
	
	public void addLecturer(Lecturer l){
		data[size] = l;
		size++;
	}
	
	public Lecturer[] getLecturersGender(){
		int count = 0; 
		for(int i = 0; i < size; i++){
			String gender = data[i].getGender();
			if(gender == "F"){
				count++;
			}
		}
		int arrayPointer = 0;
		Lecturer myLecturers[] = new Lecturer [count];  
		for(int i = 0; i < size; i++){
			String tempLecturer = data[i].getGender();
			if(tempLecturer.equals("F")){
				myLecturers[arrayPointer] = data[i];
				arrayPointer++;
			}
		}
		return myLecturers;
	}
	
	public Lecturer[] lecturerDepartment(String s){
		int count = 0;
		for(int i = 0; i < size; i++){
			String department = data[i].getDepartment();
			if(department.equals("Technology")){
				count++;
			}
		}
		int arrayPointer = 0;
		Lecturer[] lecturerDepartment = new Lecturer [count];  
		for(int i = 0; i < size; i++){
			String tempLecturer = data[i].getDepartment();
			if(tempLecturer.equals("Technology")){
				lecturerDepartment[arrayPointer] = data[i];
				arrayPointer++;
			}
		}
		return lecturerDepartment;
	}
	
	public int size(){return size;}
	
	public Lecturer[] staffNumberSearch(String s){
		Lecturer[] staffNumber = new Lecturer [1];
		for(int i = 0; i < size; i++){
			String sNumber = data[i].getStaffNumber(); 
			if(sNumber.equals(s)){
				staffNumber[0] = data[i];
			}
		}
		return staffNumber;
	}
	
	public String toString(){
		if(size == 0) return "[]";
		String s = "[";
		for(int j = 0; j < size - 1; j++)
			s = s + data[j] + ",";
		return s+data[size-1]+"]";
	}
}

//=============================================================