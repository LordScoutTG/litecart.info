package api.sendrequest;

public class DataGenerator {
    public static PostUserData getSimpleUser(){
        return PostUserData.builder()
                .firstName("Roman")
                .lastName("Ramzanov")
                .companyId(8)
                .build();

    }
}
