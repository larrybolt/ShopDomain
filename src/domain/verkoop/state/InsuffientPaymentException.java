package domain.verkoop.state;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class InsuffientPaymentException extends Exception {

    private static final long serialVersionUID = 1L;
    private double difference;

    public InsuffientPaymentException(String message, double difference) {
        super(message);
        setDifference(difference);
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

}
