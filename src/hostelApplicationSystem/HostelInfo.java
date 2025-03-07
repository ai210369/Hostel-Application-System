package hostelApplicationSystem;

//super class
public class HostelInfo {
	private String type;
	private String name;
	
	//mutators
	public void setType(String t) {
		type = t;
	}

	public void setName(String n) {
		name = n;
	}
	
	//accessors
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}