package ee.valiit.bmxback.infrastructure.error;


import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    USERNAME_UNAVAILABLE("Kasutajanimi on juba olemas", 112),
    LOCATION_NAME_UNAVAILABLE("Sõidukoht on juba olemas", 113);


    private final String message;
    private final   Integer errorCode;

    Error(String message, Integer errorCode) {
        this.message=message;
        this.errorCode=errorCode;
    }
}
