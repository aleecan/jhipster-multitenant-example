package com.mikado.mikadosaas.resource.util;

public class EnumConstants {

	public enum EmployeeType {
		EMPLOYEE, OTHER, EXTERNAL;
	}

	public enum Language {
		en, tr, ru, de
	}

	public enum Level {
		Level1, Level2, Level3
	}

	public enum CardType {
		EMPLOYEE, VISITOR, SPECIAL
	}

	public enum SubscriptionStatus {
		RUNNING, EXPIRED
	}

	public enum Type {
		All, This, Previous, Between, Close, Empty, NotEmpty, Active, Passive
	}

	public enum Reporting {
		cc_costcenters,cc_departments,cc_groupcode,cc_privatecode,location,cc_title
	}

	public enum FileType{
		pdf,excel
	}

	public enum ApproveType{
		COST_CENTER, DEPARTMENT,FIRM, MANAGERIAL

	}

}
