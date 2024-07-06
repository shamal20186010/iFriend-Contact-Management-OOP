public class Customer {
    private String id;
    private String name;
    private String conNo;
    private String company;
    private double salary;
    private String birthday;

    Customer(){}
    Customer(String id, String name,String conNo,String company,double salary,String birthday){
        this.id=id;
        this.name=name;
        this.conNo=conNo;
        this.company=company;
        this.salary=salary;
        this.birthday=birthday;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getConNo(){
        return conNo;
    }
    public String getCompanyName(){
        return company;
    }
    public double getSalary(){
        return salary;
    }
    public String getBirthday(){
        return birthday;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setConNo(String conNo){
        this.conNo=conNo;
    }
    public void setCompany(String company){
        this.company=company;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setBirthday(String birthday){
        this.birthday=birthday;
    }

}
