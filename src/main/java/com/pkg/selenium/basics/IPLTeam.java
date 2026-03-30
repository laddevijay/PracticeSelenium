package com.pkg.selenium.basics;

public class IPLTeam {
	private String teamName;
	private double nrr;
	private int points;
	
	public IPLTeam(String teamName, double nrr, int points) {
		this.teamName = teamName;
		this.nrr = nrr;
		this.points = points;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public double getNrr() {
		return nrr;
	}
	public void setNrr(double nrr) {
		this.nrr = nrr;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String toString() {
		return "IPLTeam:  [teamName=" + teamName + ", nrr=" + nrr + ", points=" + points + "]";
	}
	
}
