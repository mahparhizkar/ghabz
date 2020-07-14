package com.toranj.ghabz.validator;

import com.toranj.ghabz.entity.NaturalPerson;
import com.toranj.ghabz.utils.Validation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class NaturalPersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NaturalPerson.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NaturalPerson naturalPerson = (NaturalPerson) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationalId", "NotEmpty");
        if (naturalPerson.getNationalId().length() < 10 || naturalPerson.getNationalId().length() > 10) {
            errors.rejectValue("nationalId", "Size.naturalPersonForm.nationalId");
        }
        if (StringUtils.isNumeric(naturalPerson.getNationalId()) == false) {
            errors.rejectValue("nationalId", "Int.Format.naturalPersonForm.nationalId");
        }
        if (Validation.isValidNationalCode(naturalPerson.getNationalId()) == false) {
            errors.rejectValue("nationalId", "Format.naturalPersonForm.nationalId");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (naturalPerson.getName().length() < 2 || naturalPerson.getName().length() > 50) {
            errors.rejectValue("name", "Size.naturalPersonForm.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "family", "NotEmpty");
        if (naturalPerson.getFamily().length() < 2 || naturalPerson.getFamily().length() > 100) {
            errors.rejectValue("family", "Size.naturalPersonForm.family");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fatherName", "NotEmpty");
        if (naturalPerson.getFatherName().length() < 2 || naturalPerson.getFatherName().length() > 50) {
            errors.rejectValue("fatherName", "Size.naturalPersonForm.fatherName");
        }

    }

    //Address Validation
    public void addressValidate(Object o, Errors errors) {
        NaturalPerson naturalPerson = (NaturalPerson) o;

    }

    //profile validation
    public void profileValidate(Object o, Errors errors){
        NaturalPerson naturalPerson = (NaturalPerson) o;

        //not empty required fields
        if (naturalPerson.getName().isEmpty() || naturalPerson.getFamily().isEmpty() || naturalPerson.getMobileNumber().isEmpty() ||
                naturalPerson.getBirthDate() == null){
            errors.rejectValue("required", "required.fields");
        }

        //name
        if ((StringUtils.isNumeric(naturalPerson.getFamily()))) {
            errors.rejectValue("name", "Size.name");
        }

        //family
        if (StringUtils.isNumeric(naturalPerson.getFamily())) {
            errors.rejectValue("family", "family.name");
        }

        //mobile number
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "NotEmpty");
        if (naturalPerson.getMobileNumber().length() < 11) {
            errors.rejectValue("mobileNumber", "Size.userForm.mobile");
        }
        if (!StringUtils.isNumeric(naturalPerson.getMobileNumber())) {
            errors.rejectValue("mobileNumber", "Int.Format.userForm.mobile");
        }
        if (!Validation.isValidMobile(naturalPerson.getMobileNumber())) {
            errors.rejectValue("mobileNumber", "Format.userForm.mobile");
        }

        //birthDate
        if (naturalPerson.getBirthDate() == null) {
            errors.rejectValue("birthDateSize", "Size.birthDate");
        }
    }

    }