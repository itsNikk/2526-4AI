package Exceptions.Exercises.Pandora;

public class Coordinata {
    private double latitude;
    private double longitude;

    public Coordinata(double latitude, double longitude) {

        //if(latitude> 90.0 || latitude< -90.0) throw new IllegalArgumentException();

        checkLongitude(longitude);
        checkLatitude(latitude);

        this.latitude = latitude;
        this.longitude = longitude;
    }


    private void checkLongitude(double l) {
        if (l > 180.0 || l < -180.0) throw new IllegalArgumentException("LONGITUDINE NON VALIDA");
    }

    private void checkLatitude(double lat) {
        if (lat > 90.0 || lat < -90.0) throw new IllegalArgumentException("LATITUDINE NON VALIDA");
    }

}
