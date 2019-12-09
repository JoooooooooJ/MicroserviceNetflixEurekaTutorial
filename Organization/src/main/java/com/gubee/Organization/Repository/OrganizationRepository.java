package com.gubee.Organization.Repository;

import com.gubee.Organization.Model.Organization;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrganizationRepository {

    private List<Organization> organizations = new ArrayList<>();

    public Organization add(Organization organization) {
        organization.setId((long) (organizations.size()+1));
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
        if (organization.isPresent())
            return organization.get();
        else
            return null;
    }

    public List<Organization> findAll() {
        return organizations;
    }

}
