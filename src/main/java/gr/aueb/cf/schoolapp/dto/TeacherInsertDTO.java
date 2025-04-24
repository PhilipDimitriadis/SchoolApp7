package gr.aueb.cf.schoolapp.dto;

public class TeacherInsertDTO extends BaseDTO {

    public TeacherInsertDTO() {

    }

    public TeacherInsertDTO(String firstname, String lastname, String vat,
                            String fatherName, String phoneNumber, String email,
                            String street, String streetNum, String zipCode, Integer cityId) {
        super(firstname, lastname, vat, fatherName, phoneNumber, email, street, streetNum, zipCode, cityId);
    }
}
