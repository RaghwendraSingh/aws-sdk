package org.raghwendra;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args.length != 2) {
    		System.out.println("please provide access_key_id and secret_key_id");
    		System.exit(1);
    	}
        String accessKeyId = args[0];
        String secretKeyId = args[1];

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretKeyId);
        
        Region region = Region.US_WEST_2;
        S3Client s3 = S3Client.builder()
        				.credentialsProvider(StaticCredentialsProvider.create(awsCreds))
        				.region(region)
        				.build();
    }
}
