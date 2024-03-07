package meso.itrjwyss.barberia.data.customer;

import meso.itrjwyss.barberia.data.BaseResponse;

public class FindCustomerResponse extends BaseResponse {

    private CustomerData customer = null;

    public CustomerData getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerData customer) {
        this.customer = customer;
    }
}
