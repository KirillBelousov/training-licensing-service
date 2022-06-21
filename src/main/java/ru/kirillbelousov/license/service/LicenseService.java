package ru.kirillbelousov.license.service;

import org.springframework.stereotype.Service;
import ru.kirillbelousov.license.model.License;

@Service
public class LicenseService {

    public String createLicense(License license, String organizationId) {
        if (license != null) {
            license.setOrganizationId(organizationId);
            return String.format("The licence has been created: %s", license);
        } else {
            return "The licence has not been created. License data has not been passed";
        }
    }

    public License getLicense(String licenseId, String organizationId) {
        return createDummyLicense(licenseId, organizationId);
    }

    private License createDummyLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(42);
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Dummy License");
        license.setProductName("Dummy product name");
        license.setLicenseType("Dummy type");

        return license;
    }

    public String updateLicense(License license, String organizationId) {
        if (license != null) {
            license.setOrganizationId(organizationId);
            return String.format("The licence has been updated: %s", license);
        } else {
            return "The licence has not been updated. License data has not been passed";
        }
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
    }
}
