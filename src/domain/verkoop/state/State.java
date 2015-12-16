package domain.verkoop.state;
/**
 * 
 * @author Larry & Annelore
 *
 */
public interface State {

    String getName();

    double pay(double payment) throws InsuffientPaymentException;

    void notPayed();

    void clear();

    void removeEntry(int index);
}
