package ee.valiit.bmxback.infrastructure.status;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    PENDING("P"),
    SOFT_DELETED("D");

    private final String code;

    Status(String code) {
        this.code = code;
    }

}
