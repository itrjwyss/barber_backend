package meso.itrjwyss.barberia.data.service;

import meso.itrjwyss.barberia.data.BaseResponse;

public class FindServiceResponse extends BaseResponse {

    private ServiceData service = null;

    public ServiceData getService() {
        return service;
    }

    public void setService(ServiceData service) {
        this.service = service;
    }
}
