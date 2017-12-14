package bean;

public class BankBean {
	private String ifsc;
	private int bankID;
	private String branch;
	private String address;
	private String city;
	private String district;
	private String state;
	private String bankName;
	
//	public BankBean(String string, int parseInt, String string2, String string3, String string4, String string5,
//			String string6, String string7) {
//		// TODO Auto-generated constructor stub
//	}

	
	public BankBean(String ifsc, int bankId, String branch, String address, String city,String district, String state, String bankName){
		this.ifsc=ifsc;
		this.bankID=bankId;
		this.branch=branch;
		this.address=address;
		this.city=city;
		this.district=district;
		this.state=state;
		this.bankName=bankName;
			
	}



	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	

}
