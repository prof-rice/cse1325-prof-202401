class InvalidWidthException extends Exception {
    public InvalidWidthException() {super();}
    public InvalidWidthException(String message) {super(message);}
    public InvalidWidthException(Throwable t) {super(t);}
    public InvalidWidthException(String message, Throwable t) {super(message, t);}

    public InvalidWidthException(double width) {super("Invalid width: " + width);}
}
    
