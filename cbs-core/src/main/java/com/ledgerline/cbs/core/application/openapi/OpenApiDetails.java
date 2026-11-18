package com.ledgerline.cbs.core.application.openapi;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public final class OpenApiDetails {

    public static Contact getOpenApiContactDetails () {
        Contact contact = new Contact();
        contact.setEmail("nakshatra@metaupspace.com");
        contact.setName("Nakshatra Manglik");
        contact.setUrl("https://github.com/naksh1414");
        return contact;
    }

    public static License getOpenApiLicence () {
        return new License().name("MIT License")
            .url("https://choosealicense.com/licenses/mit/");
    }

    public static String getOpenApiTermsOfService () {
        return "https://github.com/naksh1414/ledgerline/cbs/terms";
    }
}
