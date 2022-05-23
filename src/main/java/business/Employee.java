package business;

import java.util.Observable;

/**
 * clasa utilizator de tip employee care mosteneste atributele clasei User si ii seteaza rolul la employee
 */

public class Employee extends User {
        private ROLE role;
    public Employee(int id, String name, String password,String firstName,String lastName,String address,String phoneNumber,String email)
    {
        super(id,name,password,firstName,lastName,address,phoneNumber,email);
            super.setRole(ROLE.EMPLOYEE);

        }

    }