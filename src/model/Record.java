package model;

public class Record {

	private String idType;
	private int id;
	
	private Record(int typeNumber, int id) {
		this.idType = IdType.values()[typeNumber].toString();
        this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
