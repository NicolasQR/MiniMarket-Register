package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import exceptions.DayException;
import exceptions.TypeException;

public class Store {
		public final static String ID_TYPE_NOT_ALLOWED = "TI";
	    private List<Record> records;
	    private int count;
	    
	    
	    public Store() {
	        records = new ArrayList<>();
	    }
	    
	    public void addRecord (LocalDate toDay, int typeNumber, int id) throws TypeException, DayException{
	        

	        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	        String date = dateFormat.format(toDay);
	        String[] parts = date.split("/");
	        int day = Integer.parseInt(parts[2]);

	        if(!idTypeValidation(IdType.values()[typeNumber].name())){
	            throw new TypeException(IdType.values()[typeNumber].name());
	        }

	        if(!evenDay(day, id)){
	            
	            throw new DayException(id, day);
	        }
	        Record temp = new Record(typeNumber, id);
	        records.add(temp);
	    }
	    
	    
	    public boolean evenDay(int day, int id){
	        boolean access = false;

	        if(day%2 == 0 && id%2 != 0){
	           access = true;
	        } else if (day%2 != 0 && id%2 == 0) {
	            access = true;
	        }

	        return access;
	    }
	    
	    public void addCount(){
		    count++;
		}

		public boolean idTypeValidation(String type){
	        boolean access = false;

	        if(!type.equals(ID_TYPE_NOT_ALLOWED)){
	            access = true;
	        }
	        return access;
	    }
	    
	    public List<Record> getRecords() {
		    return records;
		}

		public void setRecords(List<Record> records) {
		    this.records = records;
		}

		public long getCount() {
	        return count;
	    }

	    public void setCount(int count) {
	        this.count = count;
	    }
}
