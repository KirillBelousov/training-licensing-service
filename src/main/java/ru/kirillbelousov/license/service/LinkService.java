package ru.kirillbelousov.license.service;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import ru.kirillbelousov.license.controller.LicenseController;
import ru.kirillbelousov.license.model.License;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class LinkService {

    public WebMvcLinkBuilder getGetLicenseLink(String organizationId, String licenseId) {
        return linkTo(methodOn(LicenseController.class).getLicense(organizationId, licenseId));
    }

    public WebMvcLinkBuilder getUpdateLicenseLink(String organizationId, License license) {
        return linkTo(methodOn(LicenseController.class).updateLicense(organizationId, license));
    }

    public WebMvcLinkBuilder getDeleteLicenseLink(String organizationId, String licenseId) {
        return linkTo(methodOn(LicenseController.class).deleteLicense(organizationId, licenseId));
    }
}
