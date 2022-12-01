package IndividualProject.business;


import IndividualProject.domain.AccessToken;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
