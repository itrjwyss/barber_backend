package meso.itrjwyss.barberia.data.barber;

import meso.itrjwyss.barberia.data.BaseResponse;

public class FindBarberResponse extends BaseResponse {

    private BarberData barber = null;

    public BarberData getBarber() {
        return barber;
    }

    public void setBarber(BarberData barber) {
        this.barber = barber;
    }
}
