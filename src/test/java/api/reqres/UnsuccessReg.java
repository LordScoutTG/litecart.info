package api.reqres;

public class UnsuccessReg {
    public String error;

    public UnsuccessReg(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
