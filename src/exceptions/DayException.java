package exceptions;

public class DayException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int id;
    private int day;

    public DayException(int id,int day){
        super("The" + id + " don't match with" + day + "This day isn't the expected day to access");
        this.id = id;
        this.day = day; 
    }

    public boolean oddPairValidation(){
        boolean access = false;

        if(day%2 == 0 && id%2 != 0){
           access = true;
        } else if (day%2 != 0 && id%2 == 0) {
            access = true;
        }

        return access;
    }
}