package models.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AwsConfiguration {


    @JsonProperty("aws.configured")
    private boolean configured;

    @JsonProperty("aws.accessKeyId")
    private String accessKeyId;

    @JsonProperty("aws.accessKeySecret")
    private String accessKeySecret;

    @JsonProperty("aws.region")
    private String region;

    @JsonProperty("aws.allRegionEnabled")
    private boolean allRegionEnabled;

    @JsonProperty("aws.accountTag")
    private String accountTag;

    @JsonProperty("aws.roleArns")
    private String roleArns;


    @JsonProperty("aws.enableLoadBalancer")
    private boolean enableLoadBalancer;


    @JsonProperty("aws.enableNatGateways")
    private boolean enableNatGateways;

    @JsonProperty("aws.enableInternetGateways")
    private boolean enableInternetGateways;

    @JsonProperty("aws.enableS3Buckets")
    private boolean enableS3Buckets;

    @JsonProperty("aws.enableWorkspaces")
    private boolean enableWorkspaces;

    @JsonProperty("aws.enableLambdaFunctions")
    private boolean enableLambdaFunctions;

    @JsonProperty("aws.enableRoute53Assets")
    private boolean enableRoute53Assets;

    @JsonProperty("aws.enableIamUsers")
    private boolean enableIamUsers;

    @JsonProperty("aws.enableRdsInstances")
    private boolean enableRdsInstances;

    @JsonProperty("aws.enableEcsContainerInstances")
    private boolean enableEcsContainerInstances;

    @JsonProperty("aws.enableEc2AttachedIamRoles")
    private boolean enableEc2AttachedIamRoles;

    @JsonProperty("aws.discoverOnlyPoweredOnEc2Instances")
    private boolean discoverOnlyPoweredOnEc2Instances;

    @JsonProperty("aws.enableIamUsersServices")
    private boolean enableIamUsersServices;

    @JsonProperty("aws.resolveLoadBalancerIp")
    private boolean resolveLoadBalancerIp;

    @JsonProperty("aws.enableLoadBalancerTargets")
    private boolean enableLoadBalancerTargets;

    @JsonProperty("aws.correlateEcsContainerInstancesWithEc2Instances")
    private boolean correlateEcsContainerInstancesWithEc2Instances;


    @JsonProperty("aws.disableFetchingFromPrimaryAccount")
    private boolean disableFetchingFromPrimaryAccount;



}
