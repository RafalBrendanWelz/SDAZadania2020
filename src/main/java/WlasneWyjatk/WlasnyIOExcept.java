package WlasneWyjatk;



public class WlasnyIOExcept extends RuntimeException {

    public WlasnyIOExcept() {
        super();
    }

    public WlasnyIOExcept(String message) {
        super(message);
    }

    public WlasnyIOExcept(String message, Throwable cause) {
        super(message, cause);
    }

    public WlasnyIOExcept(Throwable cause) {
        super(cause);
    }

    protected WlasnyIOExcept(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
