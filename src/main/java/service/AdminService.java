package service;



import entity.Admin;

import java.util.List;

public interface AdminService {
    Admin addAdmin(Admin admin);
    void delete(int id);
    Admin getByName(String adminLogin);
    Admin editAdmin(Admin admin);
    List<Admin> getAll();
}
