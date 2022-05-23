package business;

/**
 * clasa utilizator de tip client care mosteneste atributele clasei User si ii seteaza rolul la client
 */
public class Client extends User{
    private ROLE role;
    public Client(int id, String name, String password,String firstName,String lastName,String address,String phoneNumber,String email)
    {
        super(id,name,password,firstName,lastName,address,phoneNumber,email);
        super.setRole(ROLE.CLIENT);

    }

}