package service.impl;

import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdminRepository;
import service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin addAdmin(Admin admin) {
        Admin savedAdmin = adminRepository.saveAndFlush(admin);
        return savedAdmin;
    }

    @Override
    public void delete(int id) {
        adminRepository.deleteById(id);

    }

    @Override
    public Admin getByName(String adminLogin) {
        return adminRepository.findAdminByAdminLogin(adminLogin);
    }

    @Override
    public Admin editAdmin(Admin admin) {
        return adminRepository.saveAndFlush(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }
}
