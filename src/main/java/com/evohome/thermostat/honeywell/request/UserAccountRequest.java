package com.evohome.thermostat.honeywell.request;

import com.evohome.thermostat.honeywell.response.UserAccount;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

public class UserAccountRequest extends AuthenticatedRequest<UserAccount, Object> {

    @Override
    public String getUrl() {
        return BASE_URL + "/userAccount";
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public ParameterizedTypeReference<UserAccount> getResponseClass() {
        return new ParameterizedTypeReference<UserAccount>() {
        };
    }
}
