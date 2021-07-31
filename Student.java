class Student{
	int rno;
	String name;
	int S1;
	int S2;
	int S3;

	public Student(){

	}	

	public Student(int rno, String name, int S1, int S2, int S3){
		this.rno = rno;
		this.name = name;
		this.S1 = S1;
		this.S2 = S2;
		this.S3 = S3;
	}

	public void setRno(int rno){this.rno = rno;}
	public int getRno() {return rno;}
	public void setName(String name){this.name = name;}
	public String getName(){return name;}
	public void setS1(int S1){this.S1 = S1;}
	public int getS1() {return S1;}
	public void setS2(int S2){this.S2 = S2;}
	public int getS2() {return S2;}
	public void setS3(int S3){this.S3= S3;}
	public int getS3() {return S3;}
}