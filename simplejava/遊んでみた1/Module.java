public class Module {
    public int userId;
    public String name;

    public Module(int userId,String name){
        this.userId = userId;
        this.name = name;
    }

    public int getUserId(){
        return this.userId;
    }

    public String getName(){
        return this.name;
    }

    
}
