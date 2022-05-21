import java.util.Stack;

public class Passenger {

    private String passengerId;
    private String survived;
    private String pClass;
    private String surname;
    private String name;
    private String gender;
    private String age;
    private String sibSp;
    private String parch;
    private String ticket;
    private String fare;
    private String cabin;
    private String embarked;

    public Passenger(Stack<String> line){
       this.embarked = line.pop();
       this.cabin = line.pop();
       this.fare = line.pop();
       this.ticket = line.pop();
       this.parch = line.pop();
       this.sibSp = line.pop();
       this.age = line.pop();
       this.gender = line.pop();
       this.name = line.pop();
       this.surname = line.pop();
       this.pClass = line.pop();
       this.survived = line.pop();
       this.passengerId = line.pop();

    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getpClass() {
        return pClass;
    }

    public String getSurvived() {
        return survived;
    }

    public String getEmbarked() {
        return embarked;
    }

    public String getCabin() {
        return cabin;
    }

    public String getFare() {
        return fare;
    }

    public String getTicket() {
        return ticket;
    }

    public String getParch() {
        return parch;
    }

    public String getSibSp() {
        return sibSp;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Id: " + this.passengerId + ", name: " + this.name;
    }

}
