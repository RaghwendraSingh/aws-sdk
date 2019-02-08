package org.raghwendra;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args.length != 3) {
    		System.out.println("please provide access_key_id and secret_key_id and new user to be created");
    		System.exit(1);
    	}
        String accessKeyId = args[0];
        String secretKeyId = args[1];
        String userName = args[2];

        // AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretKeyId);
        IAMExample iamExample = new IAMExample(accessKeyId, secretKeyId);
        // create new user
        //String resp = iamExample.createUser(userName);

        // attach user to group
        System.out.println(iamExample.attachPolicy(userName, "TestGroup"));



    }
}
