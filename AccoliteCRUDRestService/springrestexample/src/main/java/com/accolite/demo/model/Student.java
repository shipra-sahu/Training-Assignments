package com.accolite.demo.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
 
    private long rollNo;
     
    private String name;
     
    private Date dob;
    
    public Student(){
        rollNo=0;
    }

    public Student(long rollNo, String name, Date dob) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
	}

    @XmlElement
	public long getRollNo() {
		return rollNo;
	}


	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	@XmlElement
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (rollNo ^ (rollNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dob=" + dob + "]";
	}
}