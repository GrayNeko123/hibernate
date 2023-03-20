package model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class EmpBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empid")
	private Integer empid ;
	
	@Column(name = "empname")
	private String empname ;
	
	@Column(name = "salary")
	private Integer salary ;
	
	@Column(name = "sex")
	private Character sex;
	
	@Column(name = "photo")
	private Byte[] photo;
	
	@Column(name = "deptid")
	private Integer deptid;
	
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public Byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	@Override
	public String toString() {
		return "EmpBean [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", sex=" + sex + ", photo="
				+ Arrays.toString(photo) + ", deptid=" + deptid + "]";
	}
	
}
