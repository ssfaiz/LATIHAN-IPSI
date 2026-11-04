// BAD CODE
// Implementasi terbuka, tidak ada abstraksi
public class Point {
    public double x;
    public double y;
}


// GOOD CODE
// Menyembunyikan representasi, membuka perilaku
public interface Point {
    double getX();
    double getY();

    void setCartesian(double x, double y);

    double getR();
    double getTheta();

    void setPolar(double r, double theta);
}