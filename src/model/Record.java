package model;

public class Record {

	private String idType;
	private long id;
	
	public Record(int typeNumber, long id) {
		this.idType = IdType.values()[typeNumber].toString();
        this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
