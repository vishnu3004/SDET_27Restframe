package POJOCLASS;

public class PojoLIb {
public String createdBy;
public String projectName;
public String staus;
public int teamSize;
public PojoLIb(String createdBy, String projectName, String staus, int teamSize) {
	super();
	this.createdBy = createdBy;
	this.projectName = projectName;
	this.staus = staus;
	this.teamSize = teamSize;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getStaus() {
	return staus;
}
public void setStaus(String staus) {
	this.staus = staus;
}
public int getTeamSize() {
	return teamSize;
}
public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}


	


}
