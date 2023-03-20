package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class DeptBean {
	@Id
	private Integer deptid;
	
	@Column(name = "deptname", columnDefinition = "nvarchar")
	private String deptname;
	@Override
	public String toString() {
		return "DeptBean [deptid=" + deptid + ", deptname=" + deptname + "]";
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}
