package org.raghwendra;


import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.*;

public class IAMExample {
    public IamClient iam; // make this static
    public Region region = Region.AWS_GLOBAL;
    public IAMExample(String accessKeyId, String secretAccessKey) {

        iam = IamClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey)))
                .region(region).build();
    }
    public String createUser(String userName) {
        //AwsBasicCredentials.create("", "");
        //Region region = Region.AWS_GLOBAL;
        //IamClient iam = IamClient.builder().region(region).build();


        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .userName(userName)
                .build();

        CreateUserResponse response = iam.createUser(createUserRequest);

        System.out.println(response.toString());

        return response.toString();
    }

    public String attachPolicy(String userName, String groupName) {
        AddUserToGroupRequest addUserToGroupRequest = AddUserToGroupRequest.builder()
                .groupName(groupName)
                .userName(userName)
                .build();

        AttachGroupPolicyRequest.builder().groupName("").policyArn("").build();

        AddUserToGroupResponse response = iam.addUserToGroup(addUserToGroupRequest);

        return response.toString();
    }
}
