package ru.kirillbelousov.license.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kirillbelousov.license.model.License;
import ru.kirillbelousov.license.service.LicenseService;
import ru.kirillbelousov.license.service.LinkService;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;
    @Autowired
    private LinkService linkService;

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable("organizationId") String organizationId,
                                                @RequestBody License license) {
        return ResponseEntity.ok(licenseService.createLicense(license, organizationId));
    }

    @GetMapping(value = "/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
                                              @PathVariable("licenseId") String licenseId) {
        License license = licenseService.getLicense(licenseId, organizationId);
        license.add(linkService.getGetLicenseLink(organizationId, license.getLicenseId()).withSelfRel(),
                linkService.getUpdateLicenseLink(organizationId, license).withRel("updateLicense"),
                linkService.getDeleteLicenseLink(organizationId, license.getLicenseId()).withRel("deleteLicense"));
        return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable("organizationId") String organizationId,
                                                @RequestBody License license) {
        return ResponseEntity.ok(licenseService.updateLicense(license, organizationId));
    }

    @DeleteMapping(value = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,
                                                @PathVariable("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
    }
}
