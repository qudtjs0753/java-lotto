package lotto.constant;

public enum ErrorMessage {
    NOTICE("[ERROR] "),
    UNEXPECTED("예기치 않은 에러가 발생하였습니다."),
    NOT_DIVISIBLE("금액을 맞춰서 주시기 바랍니다."),
    NOT_NUMBER("숫자를 입력하셔야 합니다.");

    private final String message;
    private final StringBuilder sb = new StringBuilder();
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
       return sb.append(NOTICE.message).append(this.message).toString();
    }
}