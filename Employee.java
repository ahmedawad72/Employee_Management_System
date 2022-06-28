package projectds;
public class Employee {
    public static boolean [] ids = new boolean [1000];
    private String name;
    private int salary;
    private String  department;
    private String dob ; 
    private  int id;
    static int number=0;
    
    // constructor 
    public Employee (String name , int salary , String department , int year , int month , int day){
        this.name=name;
        this.salary=salary;
        this.department=department;
        this.dob="";  dob+=day; dob+='/'; dob+=month; dob+='/'; dob+= year;   
        for(int i=0 ; i<1000 ; i++){
            if(ids[i]==false){
                this.id=i+1;
                ids[i]=true;
                break;
            }
        }
    }

    Employee() {
        for(int i=0 ; i<1000 ; i++){
            if(ids[i]==false){
                this.id=i;
                ids[i]=true;
                break;
            }
        }
    }
    
    // setters 
    public void setName(String name){
        //System.out.println("Please Enter name");
        this.name=name;
    }
    
    public void setSalary(int salary){
        //System.out.println("Please Enter salary");
        this.salary=salary;
    }
    
    public void setDepartment(String department){
        //System.out.println("Please Enter department");
        this.department=department;
    }
    public void setDOB(int year , int month , int day){
        //System.out.println("Please Enter birth data year then month then day");
        this.dob="";
        this.dob="";  dob+=day; dob+='/'; dob+=month; dob+='/'; dob+= year;
    }
    public void setId(int id){
        this.id=id;
    }
    
    // getters 
    public String getName(){
        return name;
    } 
    
    public int getSalary(){
        return salary;
    }
    
    public String getDepartment(){
        return department;
    }
    
    public String getDOB(){
        return dob;
    }
    
    public int getId(){
        return id;
    }
    
    public void display (){
        System.out.println("name is = "+name+"\n"+"salary is = "+salary);
        System.out.println("department is = "+department+"\n"+"DOB is = "+dob);
        System.out.println("number of employee is = "+id+"\n");
    }
    
    public boolean compareTo(Employee employee)
     {
        return this.name.compareTo(employee.name) > 0;
     }
    
    public String line() {
        return  name + "-" +
                salary+ "-" +
                department+ "-" +
                dob + "-" +
                id ;
    }
    
}