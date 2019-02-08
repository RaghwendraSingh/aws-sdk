package org.raghwendra;


import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.CreateUserRequest;
import software.amazon.awssdk.services.iam.model.CreateUserResponse;

public class IAMExample {
    public IamClient iam;
    public IAMExample(AwsBasicCredentials creds) {
        iam = IamClient.builder().credentialsProvider(StaticCredentialsProvider.create(creds)).build();
    }
    public String createUser(String userName) {
        AwsBasicCredentials.create("", "");
        Region region = Region.AWS_GLOBAL;
        IamClient iam = IamClient.builder().region(region).build();

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .userName(userName).build();

        CreateUserResponse response = iam.createUser(createUserRequest);

        System.out.println(response.user().userName());

        return null;
    }
}
