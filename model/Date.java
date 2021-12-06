package model;

public class Date{ // public = The class is accessible by any other class

    private int day; // Private -> The code is only accessible within the declared class
    private int month;
    private int year;
    
    // A constructor in Java is a special method that is used to initialize objects. 

    public Date(int day, int month, int year){
        
        final int BOUNDUP  = 2021;
        final int BOUNDDOWN = 1000;
        int bisiesto = year%4;
        int currentMonth = month-1; 
        int[][] diaEnMes = {{1, 31}, // Enero
                            {2, 28}, // Febrero 
                            {3, 31}, // Marzo
                            {4, 30}, // Abril
                            {5, 31}, // Mayo
                            {6, 30}, // Junio
                            {7, 31}, // Julio
                            {8, 31}, // Agosto
                            {9, 30}, // Septiembre
                            {10, 31}, // Octubre
                            {11, 30}, // Noviembre
                            {12, 31}, // Diciembre
                            };

        if(bisiesto == 0){
            diaEnMes[1][1] = 29;
        }
        if((day > 0 && day <= diaEnMes[currentMonth][1]) && (year > BOUNDDOWN && year <= BOUNDUP)){
            setDay(day);
            setMonth(month);
            setYear(year);
        }else{
            System.out.println("Date is invalid.");
        }
        
    }

    public Date(int pyear){
        this.year =  pyear;
    }

    public Date(){
        this.year =  0;
        this.month =  0;
        this.day =  0;
    }

    // Setter
    public void setDay(int day){
        this.day = day;
    }

    public void setMonth(int pmonth){
        this.month = pmonth;
    }

    public void setYear(int pyear){
        this.year = pyear;
    }

    // Getter
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override 
    public String toString() {
        return " Day: " + this.getDay() + ", Month: " + this.getMonth() + ", Year: " + this.getYear();
    }

}


    