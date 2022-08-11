package egovframework.example.service.vo;

public class DeptVO extends PosVO{
	private String DEPT_NO;
	private String DEPT_NM;
	private String LOC;
	private int ORD;
	private String UPPER_DEPT_NO;
	
	
	public String getDEPT_NO() {
		return DEPT_NO;
	}
	public void setDEPT_NO(String dEPT_NO) {
		DEPT_NO = dEPT_NO;
	}
	public String getDEPT_NM() {
		return DEPT_NM;
	}
	public void setDEPT_NM(String dEPT_NM) {
		DEPT_NM = dEPT_NM;
	}
	public String getLOC() {
		return LOC;
	}
	public void setLOC(String lOC) {
		LOC = lOC;
	}
	public int getORD() {
		return ORD;
	}
	public void setORD(int oRD) {
		ORD = oRD;
	}
	public String getUPPER_DEPT_NO() {
		return UPPER_DEPT_NO;
	}
	public void setUPPER_DEPT_NO(String uPPER_DEPT_NO) {
		UPPER_DEPT_NO = uPPER_DEPT_NO;
	}
	
	

}
