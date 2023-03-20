package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
@NamedQueries(
		value = {
				@NamedQuery(name="bySalary", query="FROM EmpBean WHERE salary > :salary")
		}
)
public class EmpBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empid")
	private Integer empid;
	
	@Column(name="empname", columnDefinition = "NVARCHAR")
	private String empname;
	
	@Column(name="salary")
	private Integer salary;
	
	@Column(name="sex", columnDefinition = "CHAR")
	private String sex;
	
	@Column(name="photo", columnDefinition = "image")
	private byte[] photo;
	
	@Column(name="deptid")
	private Integer deptid;
	
	@Override
	public String toString() {
		return "EmpBean [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", sex=" + sex + "]";
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
}
