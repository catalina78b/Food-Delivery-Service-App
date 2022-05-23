package business;

/**
 * clasa pentru a defini un utilizator de tip admin care mosteneste atributele clasei User si seteaza rolul la admin
 */
public class Admin extends User{
    private ROLE role;
    public Admin(int id, String name, String password,String firstName,String lastName,String address,String phoneNumber,String email)
    {
        super(id,name,password,firstName,lastName,address,phoneNumber,email);
        super.setRole(ROLE.ADMIN);

    }

}
