package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proj")
public class ProjBean {
	@Id
	@Column(name = "projid")
	private Integer projid;
	
	@Column(name = "projname", columnDefinition = "nvarchar")
	private String projname;
	
	@Override
	public String toString() {
		return "ProjBean [projid=" + projid + ", projname=" + projname + "]";
	}
	public Integer getProjid() {
		return projid;
	}
	public void setProjid(Integer projid) {
		this.projid = projid;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
}
