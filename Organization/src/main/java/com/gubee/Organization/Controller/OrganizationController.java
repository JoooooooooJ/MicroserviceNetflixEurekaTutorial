package com.gubee.Organization.Controller;

import com.gubee.Organization.Client.DepartmentClient;
import com.gubee.Organization.Client.EmployeeClient;
import com.gubee.Organization.Model.Organization;
import com.gubee.Organization.Repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizationController {
        private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

        private final OrganizationRepository repository;
        private final DepartmentClient departmentClient;
        private final EmployeeClient employeeClient;

    public OrganizationController(OrganizationRepository repository, DepartmentClient departmentClient, EmployeeClient employeeClient) {
        this.repository = repository;
        this.departmentClient = departmentClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/")
    public List<Organization> findAll(){
        LOGGER.info("Department Find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        return repository.findById(id);
    }
    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
        return organization;
    }
    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }
    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }
}

