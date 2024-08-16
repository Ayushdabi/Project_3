package in.co.rays.project_3.dto;

import java.util.Date;

public class ProjectDTO  extends BaseDTO{
	
	private String projectName;
	private String teamName;
	private Date submitDate;
	private String ProjectNo;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getProjectNo() {
		return ProjectNo;
	}

	public void setProjectNo(String projectNo) {
		ProjectNo = projectNo;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
