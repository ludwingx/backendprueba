package posCarRental.constants;

public final class GeneralConstants {

    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    public static final String ID_IN_PATH = "/{id}";

    //AUTH
    public static final String AUTH = "/auth";
    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";

    //API
    public static final String API = "/api";

    //ROL
    public static final String ROL = "/rol";
    public static final String GET_ALL_ROL = "/rol";
    public static final String GET_BY_ROL_ID = "/rol/{id}";

    //BRAND
    public static final String BRAND = "/brand";
    public static final String BRANDS = "/brands";
    public static final String GET_ALL_BRANDS = "/brand";
    public static final String GET_BY_BRAND_ID = "/brand/{id}";

    //FUEL
    public static final String FUEL = "/fuel";
    public static final String FUELS = "/fuel";
    public static final String GET_BY_FUEL_ID = "/fuel/{id}";

    //TRANSMISSION
    public static final String TRANSMISSION = "/transmission";
    public static final String TRANSMISSIONS = "/transmission";
    public static final String GET_BY_TRANSMISSION_ID = "/transmission/{id}";

    //CAR
    public static final String CAR = "/car";
    public static final String GET_ALL_CARS = "/car";
    public static final String GET_BY_CAR_ID = "/car/{id}";
    public static final String SEARCH_BY_CAR = "/car/search";

    //BOOK A CAR
    public static final String BOOK_A_CAR = "/bookACar";
    public static final String GET_ALL_BOOKINGS_CAR = "/bookingsCar";
    public static final String GET_CAR_BOOKINGS_BY_USER_ID = "/bookACar/{userId}";
    public static final String CHANGE_BY_BOOKING_ID_AND_STATUS = "/bookingsCar/{bookingId}/{status}";


}
